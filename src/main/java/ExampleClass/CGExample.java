package ExampleClass;

/**
 * @Author By 71ao
 * @Created Date : 2021/6/27
 */

public class CGExample {

    public static void main(String[] args) {

        doCall();

    }

    public static void doCall(){

        B b = new B();

        C c = new C();

        D d = new D();

        b.foo("B");

        c.foo("C");

        d.foo("D");
    }
}

interface A{
    String foo(String arg);
}

class B implements A{

    @Override
    public String foo(String arg) {
        return arg;
    }
}

class C extends B{

    @Override
    public String foo(String arg) {
        return arg;
    }
}

class D extends B{


}