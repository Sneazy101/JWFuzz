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

        // Optionally, do something with the analysis results here
        // e.g., iterating through the units to print their flow sets
        // for (soot.Unit u : body.getUnits()) {
        // System.out.println(u + " -> [FallFlow: " + analysis.getFallFlowAfter(u) +
        // ", BranchFlow: " + analysis.getBranchFlowAfter(u) + "]");
        // }
    }
}