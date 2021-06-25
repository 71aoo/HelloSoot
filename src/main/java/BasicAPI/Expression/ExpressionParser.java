package BasicAPI.Expression;

import Config.SootConfig;
import soot.*;
import soot.jimple.*;
import soot.jimple.internal.AbstractStmt;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author By 71ao
 * @Created Date : 2021/6/25
 */

public class ExpressionParser {

    private final static String CLASS_NAME = "ExampleClass.BinarySearch";

    public static void main(String[] args) {

        SootConfig.setupSoot(CLASS_NAME);

        doParse(CLASS_NAME);

    }

    public static void doParse(String className){

        SootClass sootClass = Scene.v().getSootClass(className);

        SootMethod search = sootClass.getMethodByName("search");

        JimpleBody body = (JimpleBody) search.retrieveActiveBody();

        UnitPatchingChain units = body.getUnits();

        for (Unit u : units){

            if (u instanceof Stmt){

                Stmt stmt = (Stmt) u;

                if (stmt.containsInvokeExpr()){

                    // 获取 invoke 表达式
                    InvokeExpr invokeExpr = stmt.getInvokeExpr();

                    // Exp 中的参数
                    List<Value> args = invokeExpr.getArgs();


                }

                if (stmt.containsFieldRef()){

                    // 属性引用
                    FieldRef fieldRef = stmt.getFieldRef();

                }


            }
        }
    }

}
