package BasicAPI.Graph;

import Config.SootConfig;
import soot.Body;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.toolkits.graph.BriefBlockGraph;
import soot.util.cfgcmd.CFGToDotGraph;
import soot.util.dot.DotGraph;

/**
 * @Author By 71ao
 * @Created Date : 2021/6/27
 */

public class BlockControlFlowGraphGenerator {

    private final static String CLASS_NAME = "ExampleClass.BinarySearch";

    public static void main(String[] args) {

        SootConfig.setupSoot(CLASS_NAME);

        generate(CLASS_NAME);

    }

    public static void generate(String className){

        SootClass sootClass = Scene.v().getSootClass(className);

        SootMethod search = sootClass.getMethodByName("search");

        Body body = search.retrieveActiveBody();

        BriefBlockGraph blocks = new BriefBlockGraph(body);

        System.out.println(blocks);

        CFGToDotGraph cfgToDotGraph = new CFGToDotGraph();

        DotGraph dotGraph = cfgToDotGraph.drawCFG(blocks, body);


        dotGraph.plot("./GraphOutput/Block/"+ className + "CFG" + DotGraph.DOT_EXTENSION);

    }

}
