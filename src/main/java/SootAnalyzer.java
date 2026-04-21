import soot.*;
import soot.options.Options;

import java.io.File;
import java.util.Collections;

public class SootAnalyzer {

    public static void main(String[] args) {
        // The directory where your test classes are compiled
        String targetDir = "target/test-classes";

        // Check if the target directory exists
        if (!new File(targetDir).exists()) {
            System.err.println("The directory " + targetDir + " does not exist.");
            System.err.println("Please run 'mvn test-compile' first to compile your test classes.");
            return;
        }

        // Configure Soot options
        // We set prepend_classpath to false and use our own classpath so Soot doesn't try to load
        // Java 25 system classes which are unsupported by its internal ASM.
        Options.v().set_prepend_classpath(false);
        String cp = targetDir + File.pathSeparator + "target/jdk8.jar";
        Options.v().set_soot_classpath(cp);
        Options.v().set_allow_phantom_refs(true);
        Options.v().set_keep_line_number(true);
        // Add the test-classes directory to Soot's classpath
        Options.v().set_process_dir(Collections.singletonList(targetDir));
        Options.v().set_output_format(Options.output_format_jimple);
        // Write output to a specific directory (optional)
        Options.v().set_output_dir("sootOutput");

        // Load necessary classes into Scene
        Scene.v().loadNecessaryClasses();

        System.out.println("Soot has successfully loaded the following application classes:");
        for (SootClass sc : Scene.v().getApplicationClasses()) {
            System.out.println(" - " + sc.getName());

            // Example of iterating over methods and getting their active bodies (Jimple
            // representation)
            for (SootMethod sm : sc.getMethods()) {
                if (sm.isConcrete()) {
                    try {
                        Body body = sm.retrieveActiveBody();
                        System.out.println("   Method: " + sm.getSignature());
                        System.out.println("   Locals: " + body.getLocalCount() + ", Units: " + body.getUnits().size());
                    } catch (Exception e) {
                        System.err.println("   Could not retrieve body for " + sm.getSignature());
                    }
                }
            }
        }

        // Run packs to generate output (Jimple files in sootOutput directory)
        PackManager.v().writeOutput();
        System.out.println("Jimple output has been written to the 'sootOutput' directory.");
    }
}