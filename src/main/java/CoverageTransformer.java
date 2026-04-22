import soot.Body;
import soot.BodyTransformer;
import soot.toolkits.graph.BriefUnitGraph;
import soot.toolkits.graph.UnitGraph;
import java.util.Map;

public class CoverageTransformer extends BodyTransformer {

    @Override
    protected void internalTransform(Body body, String phaseName, Map<String, String> options) {
        String methodName = body.getMethod().getName();
        if (methodName.equals("<init>") || methodName.equals("<clinit>")) {
            return;
        }
        // System.out.println("Applying CoverageTransformer to method: " + body.getMethod().getSignature());

        // Create a Control Flow Graph (CFG) for the method body.
        // BriefUnitGraph handles basic CFG without exceptional edges.
        // You can use ExceptionalUnitGraph if you need to track exception flows.
        UnitGraph graph = new BriefUnitGraph(body);

        // Run your custom ForwardBranchedFlowAnalysis on the graph
        CoverageAnalysis analysis = new CoverageAnalysis(graph);

        // After the analysis is done, we can just ask the reporter to print the accumulated test cases.
        // TestValues is now persistent and doesn't need to be extracted from flow sets.
        TestValues reporter = analysis.getReporter();
        if (reporter != null) {
            // reporter.printTestValues();

            String className = body.getMethod().getDeclaringClass().getShortName();
            methodName = body.getMethod().getName();
            String safeMethodName = methodName.replaceAll("[^a-zA-Z0-9_]", "_");
            String testClassName = className + "_" + safeMethodName + "Test";
            
            String junitCode = reporter.generateJUnitTest(className, methodName);
            
            // Save to file
            try {
                java.io.File dir = new java.io.File("src/test/java/generated");
                if (!dir.exists()) dir.mkdirs();
                java.io.File file = new java.io.File(dir, testClassName + ".java");
                try (java.io.FileWriter fw = new java.io.FileWriter(file)) {
                    fw.write(junitCode);
                }
                // System.out.println("Saved JUnit test to " + file.getAbsolutePath());
            } catch (java.io.IOException e) {
                System.err.println("Failed to save JUnit test: " + e.getMessage());
            }
        }

        // Print the resolved equations collected by the Tracer for debugging
        if (!graph.getTails().isEmpty()) {
            Tracer finalFlow = (Tracer) analysis.getFallFlowAfter(graph.getTails().get(0));
            if (finalFlow != null) {
                // System.out.println("--- Symbolic Tracer State for " + body.getMethod().getName() + " ---");
                // System.out.println(finalFlow.toString());
                // System.out.println("----------------------------------------\n");
            }
        }
    }
}