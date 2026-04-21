import soot.PackManager;
import soot.Scene;
import soot.SootClass;
import soot.Transform;
import soot.options.Options;

import java.util.Collections;

public class CoverageMain {
    public static void main(String[] args) {
        // Keep line numbers for debugging or reporting
        Options.v().set_keep_line_number(true);

        // Tell Soot to use the test-classes directory
        String targetDir = "target/test-classes";
        Options.v().set_process_dir(Collections.singletonList(targetDir));

        // Use the system classpath to find standard library classes like java.lang.Object
        Options.v().set_prepend_classpath(true);

        // Allow phantom references for things that Soot can't find
        Options.v().set_allow_phantom_refs(true);

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
        for (SootClass sc : Scene.v().getApplicationClasses()) {
            System.out.println(" - " + sc.getName());
        }

        // Run packs to generate output and apply our transformer
        PackManager.v().runPacks();
        PackManager.v().writeOutput();

        System.out.println("Analysis completed successfully.");
    }
}
