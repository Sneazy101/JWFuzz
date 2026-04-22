import soot.Local;
import soot.RefType;
import soot.Unit;
import soot.Value;
import soot.jimple.IfStmt;
import soot.toolkits.graph.UnitGraph;
import soot.toolkits.scalar.ForwardBranchedFlowAnalysis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CoverageAnalysis extends ForwardBranchedFlowAnalysis<Tracer> {

    final UnitGraph graph;
    public TestValues reporter;

    public CoverageAnalysis(UnitGraph graph) {
        super(graph);
        this.graph = graph;
        
        // Initialize the persistent reporter
        Map<Value, ArrayList<String>> map = new java.util.HashMap<>();
        Map<Value, soot.Type> dataTypes = new java.util.HashMap<>();
        List<Value> functionInputs = new ArrayList<>();
        for (Local l : graph.getBody().getLocals()) {
            map.put(l, new ArrayList<String>());
            dataTypes.put(l, l.getType());
        }
        for (Value v : graph.getBody().getParameterLocals()) {
            functionInputs.add(v);
        }
        this.reporter = new TestValues(map, dataTypes, functionInputs);

        doAnalysis();
    }

    public TestValues getReporter() {
        return reporter;
    }

    @Override
    protected Tracer newInitialFlow() {
        return new Tracer();
    }

    @Override
    protected void merge(Tracer dest, Tracer a1, Tracer a2) {
        dest.copy(a1);
        dest.merge(a2);
    }

    @Override
    protected void copy(Tracer source, Tracer dest) {
        dest.copy(source);
    }

    private void HandleCondition(Value condition, Tracer tracer) {
        if (condition instanceof soot.jimple.BinopExpr) {
            soot.jimple.BinopExpr binopExpr = (soot.jimple.BinopExpr) condition;
            Value leftOp = binopExpr.getOp1();
            Value rightOp = binopExpr.getOp2();
            String expr = binopExpr.toString();

            // Extract the operator string
            String operator = "";
            if (expr.contains("==")) operator = "==";
            else if (expr.contains("!=")) operator = "!=";
            else if (expr.contains(">=")) operator = ">=";
            else if (expr.contains("<=")) operator = "<=";
            else if (expr.contains(">")) operator = ">";
            else if (expr.contains("<")) operator = "<";
            else operator = "?";

            // Add the equation to our Tracer's Expression Tree using resolved symbolic values
            Tracer.ExprNode leftNode = tracer.resolveValue(leftOp);
            Tracer.ExprNode rightNode = tracer.resolveValue(rightOp);
            Tracer.ExprNode eqNode = new Tracer.BinaryOpNode(operator, leftNode, rightNode);
            tracer.addEquation(eqNode);

            // Report the test values persistently using leftOp's type
            if (leftOp.getType() == soot.IntType.v() || leftOp.getType() == soot.BooleanType.v()) {
                if (expr.contains("==")) {
                    reporter.addNewTestCase(leftOp, rightOp.toString());
                } else if (expr.contains("!=")) {
                    reporter.addNewTestCase(leftOp, rightOp.toString());
                } else if (expr.contains(">")) {
                    reporter.addNewTestCase(leftOp, rightOp.toString());
                } else if (expr.contains("<")) {
                    reporter.addNewTestCase(leftOp, rightOp.toString());
                } else if (expr.contains(">=")) {
                    reporter.addNewTestCase(leftOp, rightOp.toString());
                } else if (expr.contains("<=")) {
                    reporter.addNewTestCase(leftOp, rightOp.toString());
                }
            } else if (leftOp.getType() == soot.FloatType.v()) {
                if (expr.contains("==")) {
                    reporter.addNewTestCase(leftOp, rightOp.toString());
                } else if (expr.contains("!=")) {
                    reporter.addNewTestCase(leftOp, rightOp.toString());
                } else if (expr.contains(">")) {
                    reporter.addNewTestCase(leftOp, rightOp.toString());
                } else if (expr.contains("<")) {
                    reporter.addNewTestCase(leftOp, rightOp.toString());
                } else if (expr.contains(">=")) {
                    reporter.addNewTestCase(leftOp, rightOp.toString());
                } else if (expr.contains("<=")) {
                    reporter.addNewTestCase(leftOp, rightOp.toString());
                }
            } else if (leftOp.getType().toString().equals("java.lang.String")) {
                if (expr.contains("==")) {
                    reporter.addNewTestCase(leftOp, rightOp.toString());
                } else if (expr.contains("!=")) {
                    reporter.addNewTestCase(leftOp, rightOp.toString());
                }
            }
        }
    }

    @Override
    protected void flowThrough(Tracer in, Unit s, List<Tracer> fallOut, List<Tracer> branchOuts) {
        // 1. Copy incoming state to all fallthrough targets
        for (Tracer out : fallOut) {
            copy(in, out);
        }
        
        // 2. Copy incoming state to all branch targets
        for (Tracer out : branchOuts) {
            copy(in, out);
        }

        // Track assignments to build symbolic state
        if (s instanceof soot.jimple.AssignStmt) {
            soot.jimple.AssignStmt assign = (soot.jimple.AssignStmt) s;
            Value leftOp = assign.getLeftOp();
            Value rightOp = assign.getRightOp();
            
            Tracer.ExprNode rightNode = null;
            
            if (rightOp instanceof soot.jimple.BinopExpr) {
                soot.jimple.BinopExpr binop = (soot.jimple.BinopExpr) rightOp;
                Tracer.ExprNode r1 = in.resolveValue(binop.getOp1());
                Tracer.ExprNode r2 = in.resolveValue(binop.getOp2());
                
                String exprStr = rightOp.toString();
                String operator = "?";
                if (exprStr.contains(" + ")) operator = "+";
                else if (exprStr.contains(" - ")) operator = "-";
                else if (exprStr.contains(" * ")) operator = "*";
                else if (exprStr.contains(" / ")) operator = "/";
                else if (exprStr.contains(" % ")) operator = "%";
                else if (exprStr.contains(" & ")) operator = "&";
                else if (exprStr.contains(" | ")) operator = "|";
                else if (exprStr.contains(" ^ ")) operator = "^";
                else if (exprStr.contains(" << ")) operator = "<<";
                else if (exprStr.contains(" >> ")) operator = ">>";
                else if (exprStr.contains(" >>> ")) operator = ">>>";
                
                rightNode = new Tracer.BinaryOpNode(operator, r1, r2);
            } else {
                rightNode = in.resolveValue(rightOp);
            }
            
            if (rightNode != null) {
                for (Tracer out : fallOut) {
                    out.putSymbol(leftOp.toString(), rightNode);
                }
                for (Tracer out : branchOuts) {
                    out.putSymbol(leftOp.toString(), rightNode);
                }
            }
        }

        if (s instanceof IfStmt) {
            IfStmt ifStmt = (IfStmt) s;
            Value condition = ifStmt.getCondition();
            
            // Apply the condition analysis to the outgoing flow sets
            for (Tracer out : fallOut) {
                HandleCondition(condition, out);
            }
            for (Tracer out : branchOuts) {
                HandleCondition(condition, out);
            }
        }
    }
}
