package BasicAPI.Class;

import Config.SootConfig;
import soot.*;
import soot.util.Chain;

import java.util.List;

/**
 * @Author By 71ao
 * @Created Date : 2021/6/23
 */

public class ClassParser {

    private final static String CLASS_NAME = "ExampleClass.BasicClass";

    public static void main(String[] args) {

        SootConfig.setupSoot(CLASS_NAME);

        doParse(CLASS_NAME);

    }

    public static void doParse(String className){

        SootClass sootClass = Scene.v().getSootClass(className);

        // 包名 + 类名
        String name = sootClass.getName();

        // 所属包名
        String javaPackageName = sootClass.getJavaPackageName();

        // 类名
        String javaStyleName = sootClass.getJavaStyleName();

        // 类的修饰符
        String modifiers = Modifier.toString(sootClass.getModifiers());

        // 获取父类
        SootClass superclass = sootClass.getSuperclass();

        // 获取实现接口
        Chain<SootClass> interfaces = sootClass.getInterfaces();

        // 获取类中的所有属性, 不包括父类属性
        Chain<SootField> fields = sootClass.getFields();

        // 获取类中的所有方法, 不包括父类的方法
        List<SootMethod> methods = sootClass.getMethods();

        System.out.println(
                "【Class Full Name】=> " + name + "\n" +
                "【Class Package】=> " + javaPackageName + "\n" +
                "【Class Name】=> " + javaStyleName + "\n" +
                "【Class Modifiers】=> " + modifiers +"\n" +
                "【Superclass】=> " + superclass + "\n" +
                "【Implement interfaces】=> " + interfaces + "\n" +
                "【All Fields】=> " + fields + "\n" +
                "【All Methods】=> " + methods
        );

    }


}
