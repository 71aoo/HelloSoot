package BasicAPI.MethodBody;

import Config.SootConfig;
import soot.*;
import soot.jimple.JimpleBody;
import soot.util.Chain;

import java.util.List;

/**
 * @Author By 71ao
 * @Created Date : 2021/6/24
 */

public class MethodBodyParser {

    private final static String CLASS_NAME = "ExampleClass.BinarySearch";

    public static void main(String[] args) {

        SootConfig.setupSoot(CLASS_NAME);

        doParse(CLASS_NAME);

    }

    public static void doParse(String className){

        SootClass sootClass = Scene.v().getSootClass(className);

        SootMethod search = sootClass.getMethodByName("search");

        // 获取方法体，Jimple 码
        JimpleBody body = ((JimpleBody) search.retrieveActiveBody());

        // 获取 Jimple 码中所有局部变量
        Chain<Local> locals = body.getLocals();

        // statement
        UnitPatchingChain units = body.getUnits();

        //  所有被重新定义的Box
        List<ValueBox> defBoxes = body.getDefBoxes();

        //  所有被使用的Box
        List<ValueBox> useBoxes = body.getUseBoxes();

        System.out.println(
                "【Method Jimple Code】" + "\n" + body +
                "【Method Local Variable】=> " + locals + "\n" +
                "【Method Statement】=> " + units + "\n" +
                "【Method Defined Value】=> " + defBoxes + "\n" +
                "【Method Used Value】=> " + useBoxes
        );


    }
}
