package BasicAPI.Graph;

import Config.SootConfig;
import soot.Body;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.toolkits.graph.BriefBlockGraph;
import soot.toolkits.graph.BriefUnitGraph;
import soot.util.cfgcmd.CFGToDotGraph;
import soot.util.dot.DotGraph;

/**
 * @Author By 71ao
 * @Created Date : 2021/6/27
 */

public class UnitControlFlowGraphGenerator {

    private final static String CLASS_NAME = "ExampleClass.BinarySearch";

    public static void main(String[] args) {

        SootConfig.setupSoot(CLASS_NAME);

        generate(CLASS_NAME);

    }


    public static void generate(String className){

        SootClass sootClass = Scene.v().getSootClass(className);

        SootMethod search = sootClass.getMethodByName("search");

        Body body = search.retrieveActiveBody();

        BriefUnitGraph units = new BriefUnitGraph(body);

        CFGToDotGraph cfgToDotGraph = new CFGToDotGraph();

        DotGraph dotGraph = cfgToDotGraph.drawCFG(units, body);

        dotGraph.plot("./GraphOutput/CFG/"+ className + "CFG" + DotGraph.DOT_EXTENSION);

    }
}
