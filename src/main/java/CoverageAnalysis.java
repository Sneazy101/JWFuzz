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
        System.out.println("STARTED READING THE FILE X_X");
        Map<Value, ArrayList<String>> map = new java.util.HashMap<>();
        Map<Value, soot.Type> dataTypes = new java.util.HashMap<>();
        for(Local l : graph.getBody().getLocals()) {
            if (l.getType() instanceof RefType && ((RefType) l.getType()).getClassName().equals("ca.sfu.cmpt745.ex06.kittens.Kitten")) {
                if(!map.containsKey(l)){
                    map.put(l, new ArrayList<String>());
                    dataTypes.put(l, l.getType());
                }
            }
        }
        return new TestValues(map, dataTypes);
    }

    @Override
    protected void merge(TestValues testValues, TestValues a1, TestValues a2) {
        testValues.merge(a1);
        testValues.merge(a2);
    }

    @Override
    protected void copy(TestValues testValues, TestValues a1){
        testValues.copy(a1);
    }

    @Override
    protected void flowThrough(TestValues testValues, Unit s, List<TestValues> list, List<TestValues> list1) {
        // First intial simple implementation of flow through
        if(s instanceof IfStmt){
            IfStmt ifStmt = (IfStmt) s;
            Value condition = ifStmt.getCondition();
            // Here you can analyze the condition and update testValues accordingly
            // For example, if the condition is a comparison of a variable to a constant, you can track that information
            // This is just a placeholder for your actual analysis logic
            System.out.println("Analyzing XXXXXXXXXXXXXXXX condition: " + condition);
        }

    }
}
