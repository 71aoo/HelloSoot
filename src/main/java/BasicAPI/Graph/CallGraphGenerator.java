package BasicAPI.Graph;

import Config.SootConfig;
import com.google.common.graph.Graph;
import soot.*;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Edge;
import soot.jimple.toolkits.callgraph.SlowCallGraph;
import soot.jimple.toolkits.callgraph.Targets;
import soot.jimple.toolkits.thread.mhp.PegCallGraphToDot;
import soot.util.Chain;
import soot.util.dot.DotGraph;
import soot.util.dot.DotGraphEdge;
import soot.util.dot.DotGraphUtility;

import java.util.Iterator;

/**
 * @Author By 71ao
 * @Created Date : 2021/6/27
 */

public class CallGraphGenerator {

    private final static String CLASS_NAME = "ExampleClass.CGExample";

    private final static DotGraph DOT_GRAPH = new DotGraph(CLASS_NAME.split("\\.")[1] + "CG");

    public static void main(String[] args) {

        SootConfig.setupSoot(CLASS_NAME);

        generate(CLASS_NAME);

    }

    public static void generate(String className){

        CallGraph callGraph = Scene.v().getCallGraph();

        SootClass mainClass = Scene.v().getMainClass();

        SootMethod main = mainClass.getMethodByName("main");

        generate(callGraph, main);

        DOT_GRAPH.plot("./GraphOutput/CG/"+ className + "CFG" + DotGraph.DOT_EXTENSION);

    }

    public static void generate(CallGraph cg, SootMethod sootMethod){

        Iterator<Edge> edges = cg.edgesOutOf(sootMethod);

        while (edges.hasNext()){

            Edge edge = edges.next();

            if (edge.isClinit()) continue;

            SootMethod src = edge.src();

            SootMethod tgt = edge.tgt();

            // 创建 node 和创建 edge
            DOT_GRAPH.drawEdge(src.getSignature(), tgt.getSignature());

            generate(cg, tgt);
        }

    }
}
