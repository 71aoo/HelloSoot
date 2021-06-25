package BasicAPI.Statement;

import Config.SootConfig;
import soot.*;
import soot.jimple.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author By 71ao
 * @Created Date : 2021/6/25
 */

public class StatementParser {

    private final static String CLASS_NAME = "ExampleClass.BinarySearch";

    public static void main(String[] args) {

        SootConfig.setupSoot(CLASS_NAME);

        doParse(CLASS_NAME);

    }

    public static void doParse(String className){

        SootClass sootClass = Scene.v().getSootClass(className);

        SootMethod search = sootClass.getMethodByName("search");

        Body body = search.retrieveActiveBody();

        UnitPatchingChain units = body.getUnits();

        for (Unit u : units){

            if (u instanceof Stmt){

                Stmt stmt = (Stmt) u;

                List<String> stmtType = getStmtType(stmt);

                System.out.println(stmt + " --> " + stmtType);
            }
        }

    }

    /**
     * 获取 Stmt 类型
     * @param stmt  原抽象语句
     * @return
     */
    public static List<String> getStmtType(Stmt stmt){

        ArrayList<String> typeList = new ArrayList<>();

        // 定义或赋值语句
        if (stmt instanceof DefinitionStmt){
            typeList.add("DefinitionStmt");
        }

        // 赋值语句
        if (stmt instanceof AssignStmt){
            typeList.add("AssignStmt");
        }

        // 调用语句
        if (stmt instanceof InvokeStmt){
            typeList.add("InvokeStmt");
        }

        // if 判断语句
        if (stmt instanceof IfStmt){
            typeList.add("IfStmt");

            IfStmtParse(((IfStmt) stmt));
        }

        if (stmt instanceof GotoStmt){
            typeList.add("GotoStmt");
        }

        // return 语句
        if (stmt instanceof ReturnStmt){
            typeList.add("ReturnStmt");
        }

        /**
         * 除以上类型以外，soot.Jimple包下还有很多
         * IdentityStmt
         * SwitchStmt
         * LookupSwitchStmt
         * TableSwitchStmt
         * BreakpointStmt
         * RetStmt
         * ReturnVoidStmt
         * NopStmt
         * OpStmt
         * ThrowStmt
         * .....
         */

        return typeList;

    }

    public static void IfStmtParse(IfStmt ifStmt){

        // 获取 if 条件
        Value condition = ifStmt.getCondition();

        // 条件成立执行的语句
        Stmt target = ifStmt.getTarget();

        System.out.println("condition: " + condition + " --> " + "target: " + target);
    }
}
