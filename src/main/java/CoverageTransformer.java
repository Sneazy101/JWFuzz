import soot.Body;
import soot.BodyTransformer;
import soot.toolkits.graph.BriefUnitGraph;
import soot.toolkits.graph.UnitGraph;
import java.util.Map;

public class CoverageTransformer extends BodyTransformer {

    @Override
    protected void internalTransform(Body body, String phaseName, Map<String, String> options) {
        System.out.println("Applying CoverageTransformer to method: " + body.getMethod().getSignature());

        // Create a Control Flow Graph (CFG) for the method body.
        // BriefUnitGraph handles basic CFG without exceptional edges.
        // You can use ExceptionalUnitGraph if you need to track exception flows.
        UnitGraph graph = new BriefUnitGraph(body);

        // Run your custom ForwardBranchedFlowAnalysis on the graph
        CoverageAnalysis analysis = new CoverageAnalysis(graph);

        // After the analysis is done, we can extract the accumulated TestValues.
        // Because of the flow analysis, the final values at the exit points (tails) of the method
        // will contain the accumulated test cases.
        if (!graph.getTails().isEmpty()) {
            // Get the flow from the first tail node
            TestValues finalFlow = (TestValues) analysis.getFallFlowAfter(graph.getTails().get(0));
            
            // If there are multiple exit points, merge their results
            for (int i = 1; i < graph.getTails().size(); i++) {
                TestValues otherFlow = (TestValues) analysis.getFallFlowAfter(graph.getTails().get(i));
                if (finalFlow != null && otherFlow != null) {
                    finalFlow.merge(otherFlow);
                }
            }
            
            // Print the final accumulated values for this method
            if (finalFlow != null) {
                finalFlow.printTestValues();
            }
        } else {
            // Fallback if the method has no exit points
            soot.Unit lastUnit = body.getUnits().getLast();
            if (lastUnit != null) {
                TestValues flow = (TestValues) analysis.getFallFlowAfter(lastUnit);
                if (flow != null) {
                    flow.printTestValues();
                }
            }
        }
    }
}