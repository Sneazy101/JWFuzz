import soot.Local;
import soot.RefType;
import soot.Unit;
import soot.Value;
import soot.jimple.IfStmt;
import soot.toolkits.graph.UnitGraph;
import soot.toolkits.scalar.ArraySparseSet;
import soot.toolkits.scalar.FlowSet;
import soot.toolkits.scalar.ForwardBranchedFlowAnalysis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Example ForwardBranchedFlowAnalysis
// Here we use FlowSet<Object> as a generic set, you can replace Object with the specific data type
// you want to track (e.g. Local variables, Constant values, Definitions).
public class CoverageAnalysis extends ForwardBranchedFlowAnalysis<TestValues> {

    final UnitGraph graph;

    public CoverageAnalysis(UnitGraph graph) {
        super(graph);
        this.graph = graph;
        doAnalysis();
    }

    @Override
    protected TestValues newInitialFlow() {
        Map<Value, ArrayList<String>> map = new java.util.HashMap<>();
        Map<Value, soot.Type> dataTypes = new java.util.HashMap<>();
        List<Value> functionInputs = new ArrayList<>();
        // System.out.println( " -------------------------- START OF LOCAL VARIABLES
        // ---------------------------- " );
        for (Local l : graph.getBody().getLocals()) {
            // System.out.println("Analyzing local variable: " + l + " of type: " +
            // l.getType());
            map.put(l, new ArrayList<String>());
            dataTypes.put(l, l.getType());
        }
        // System.out.println( " ----------------------------------END OF LOCAL
        // VARIABLES ------------------------------- " );
        // System.out.println( " -------------------------- START OF INPUT VARIABLES
        // ---------------------------- " );
        for (Value v : graph.getBody().getParameterLocals()) {
            // System.out.println("Tracking variable: " + v + " of type: " +
            // dataTypes.get(v));
            functionInputs.add(v);
        }
        // System.out.println(" ----------------------------------END OF INPUT
        // VARIABLES------------------------------- ");

        return new TestValues(map, dataTypes, functionInputs);
    }

    @Override
    protected void merge(TestValues testValues, TestValues a1, TestValues a2) {
        testValues.merge(a1);
        testValues.merge(a2);
    }

    @Override
    protected void copy(TestValues testValues, TestValues a1) {
        testValues.copy(a1);
    }

    private void HandleCondition(Value condition, TestValues testValues) {
        // Here you can analyze the condition and update testValues accordingly
        // For example, if the condition is a comparison of a variable to a constant,
        // you can track that information
        // This is just a placeholder for your actual analysis logic
        if (condition instanceof soot.jimple.BinopExpr) {
            System.out.println("Analyzing condition: " + condition);
            soot.jimple.BinopExpr binopExpr = (soot.jimple.BinopExpr) condition;
            Value leftOp = binopExpr.getOp1();
            Value rightOp = binopExpr.getOp2();
            String expr = binopExpr.toString();
            if (binopExpr.getType() == soot.IntType.v()) {
                if (expr.contains("==")) {
                    testValues.addNewTestCase(leftOp, rightOp.toString());
                } else if (expr.contains("!=")) {
                    testValues.addNewTestCase(leftOp, rightOp.toString());
                } else if (expr.contains(">")) {
                    testValues.addNewTestCase(leftOp, rightOp.toString());
                } else if (expr.contains("<")) {
                    testValues.addNewTestCase(leftOp, rightOp.toString());
                } else if (expr.contains(">=")) {
                    testValues.addNewTestCase(leftOp, rightOp.toString());
                } else if (expr.contains("<=")) {
                    testValues.addNewTestCase(leftOp, rightOp.toString());
                }
            } else if (binopExpr.getType() == soot.FloatType.v()) {
                if (expr.contains("==")) {
                    testValues.addNewTestCase(leftOp, rightOp.toString());
                } else if (expr.contains("!=")) {
                    testValues.addNewTestCase(leftOp, rightOp.toString());
                } else if (expr.contains(">")) {
                    testValues.addNewTestCase(leftOp, rightOp.toString());
                } else if (expr.contains("<")) {
                    testValues.addNewTestCase(leftOp, rightOp.toString());
                } else if (expr.contains(">=")) {
                    testValues.addNewTestCase(leftOp, rightOp.toString());
                } else if (expr.contains("<=")) {
                    testValues.addNewTestCase(leftOp, rightOp.toString());
                }
            } else if (binopExpr.getType() == soot.RefType.v("java.lang.String")) {
                if (expr.contains("==")) {
                    testValues.addNewTestCase(leftOp, rightOp.toString());
                } else if (expr.contains("!=")) {
                    testValues.addNewTestCase(leftOp, rightOp.toString());
                }
            }
            // Analyze the left and right operands of the binary expression
            // System.out.println("Left operand: " + leftOp + " of type: " +
            // leftOp.getType());
            // System.out.println("Right operand: " + rightOp + " of type: " +
            // rightOp.getType());
            // You can add logic here to update testValues based on the analysis of the
            // condition
        }
    }

    @Override
    protected void flowThrough(TestValues in, Unit s, List<TestValues> fallOut, List<TestValues> branchOuts) {
        // In Soot's ForwardBranchedFlowAnalysis, you MUST propagate the incoming state ('in')
        // to the outgoing edges ('fallOut' and 'branchOuts'). Otherwise, the state is lost!
        
        // 1. Copy incoming state to all fallthrough targets
        for (TestValues out : fallOut) {
            copy(in, out);
        }
        
        // 2. Copy incoming state to all branch targets
        for (TestValues out : branchOuts) {
            copy(in, out);
        }

        if (s instanceof IfStmt) {
            IfStmt ifStmt = (IfStmt) s;
            Value condition = ifStmt.getCondition();
            
            // Apply the condition analysis to the outgoing flow sets
            for (TestValues out : fallOut) {
                HandleCondition(condition, out);
            }
            for (TestValues out : branchOuts) {
                HandleCondition(condition, out);
            }
        }
    }
}
