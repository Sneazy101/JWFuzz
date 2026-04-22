import soot.PackManager;
import soot.Scene;
import soot.SootClass;
import soot.Transform;
import soot.options.Options;

import java.util.Collections;

public class CoverageMain {
    public static void main(String[] args) {
        // Clear old JUnit files before generating new ones
        java.io.File generatedDir = new java.io.File("src/test/java/generated");
        if (generatedDir.exists() && generatedDir.isDirectory()) {
            for (java.io.File f : generatedDir.listFiles()) {
                if (f.isFile() && f.getName().endsWith(".java")) {
                    f.delete();
                }
            }
        }

        // Find target class dynamically from src/test/java
        java.io.File srcDir = new java.io.File("src/test/java");
        String targetClass = null;
        if (srcDir.exists() && srcDir.isDirectory()) {
            for (java.io.File f : srcDir.listFiles()) {
                if (f.isFile() && f.getName().endsWith(".java")) {
                    targetClass = f.getName().replace(".java", "");
                    break; // Just use the first one we find
                }
            }
        }

        if (targetClass == null) {
            System.err.println("No .java file found in src/test/java to analyze!");
            return;
        }

        System.out.println("Dynamically targeting class: " + targetClass);

        // Keep line numbers for debugging or reporting
        Options.v().set_keep_line_number(true);

        String targetDir = "target/test-classes";
        
        // Instead of processing the entire directory (which might contain old/generated classes),
        // we explicitly set the main class/classes we want to process.
        Options.v().set_process_dir(Collections.emptyList()); 
        
        Options.v().set_prepend_classpath(false);
        String cp = targetDir + java.io.File.pathSeparator + "target/jdk8.jar";
        Options.v().set_soot_classpath(cp);

        // Allow phantom references for things that Soot can't find
        Options.v().set_allow_phantom_refs(true);

        SootClass sc = Scene.v().loadClassAndSupport(targetClass);
        sc.setApplicationClass();

        // Set output to Jimple
        Options.v().set_output_format(Options.output_format_jimple);

        // Instantiate your custom transformer
        final var transformer = new CoverageTransformer();
        
        // Wrap your transformer in a Soot Transform object
        // "jtp" is the Jimple Transformation Pack.
        final var transform = new Transform("jtp.CoverageTransformer", transformer);
        
        // Add your transform to the pack manager
        PackManager.v().getPack("jtp").add(transform);

        // Instead of soot.Main.main(args), run the packs programmatically
        // First load the classes
        Scene.v().loadNecessaryClasses();

        System.out.println("Soot has successfully loaded the following application classes:");
        for (SootClass loadedSc : Scene.v().getApplicationClasses()) {
            System.out.println(" - " + loadedSc.getName());
        }

        // Run packs to generate output and apply our transformer
        PackManager.v().runPacks();
        PackManager.v().writeOutput();

        System.out.println("Analysis completed successfully.");
    }
}
