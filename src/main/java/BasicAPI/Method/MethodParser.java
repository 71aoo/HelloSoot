package BasicAPI.Method;

import Config.SootConfig;
import soot.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author By 71ao
 * @Created Date : 2021/6/24
 */

public class MethodParser {

    private final static String CLASS_NAME = "ExampleClass.BasicClass";

    public static void main(String[] args) {

        SootConfig.setupSoot(CLASS_NAME);

        doParse(CLASS_NAME);
    }

    public static void doParse(String className){

        SootClass sootClass = Scene.v().getSootClass(className);

        List<SootMethod> methods = sootClass.getMethods();

        System.out.println("【Class Name】=> " + sootClass.getName());

        System.out.println("---------------------------------------------------");

        for (SootMethod sootMethod : methods){

            // 方法签名
            String signature = sootMethod.getSignature();

            // 方法声明
            String declaration = sootMethod.getDeclaration();

            // 方法名
            String methodName = sootMethod.getName();

            // 方法修饰符
            String modifiers = Modifier.toString(sootMethod.getModifiers());

            // 方法返回值类型
            Type returnType = sootMethod.getReturnType();

            // 方法抛出异常
            List<SootClass> exceptions = sootMethod.getExceptions();

            // 方法参数个数
            int parameterCount = sootMethod.getParameterCount();

            ArrayList<Type> types = new ArrayList<>();

            for (int i = 0; i < parameterCount; i++) {

                Type parameterType = sootMethod.getParameterType(i);

                types.add(parameterType);
            }

            System.out.println("【Method signature】=> " + signature + "\n" +
                    "【Method Declaration】=> " + declaration + "\n" +
                    "【Method Name】=> " + methodName + "\n" +
                    "【Method Modifiers】=> " + modifiers + "\n" +
                    "【Method Return Type】=> " + returnType + "\n" +
                    "【Method Throw Exception】=> " + exceptions + "\n" +
                    "【Method Parameter type】=> " + types + "\n" +
                    "---------------------------------------------------"
                    );

        }



    }
}
