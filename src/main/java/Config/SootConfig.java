package Config;

import soot.PackManager;
import soot.Scene;
import soot.SootClass;
import soot.options.Options;

import java.io.File;

/**
 * @Author By 71ao
 * @Created Date : 2021/6/20
 */

public abstract class SootConfig {

    private final static String EXAMPLE_ClASS_PATH = System.getProperty("user.dir") + File.separator + "target" + File.separator + "classes";

    public static void setupSoot(String className) {

        Options.v().set_prepend_classpath(true);
        Options.v().set_allow_phantom_refs(true);
        Options.v().set_whole_program(true);
        PackManager.v().runPacks();
        Options.v().set_soot_classpath(EXAMPLE_ClASS_PATH);
        SootClass sc = Scene.v().loadClassAndSupport(className);
        sc.setApplicationClass();
        Scene.v().loadNecessaryClasses();


    }
}
