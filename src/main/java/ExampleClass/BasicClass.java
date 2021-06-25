package ExampleClass;

/**
 * @Author By 71ao
 * @Created Date : 2021/6/23
 */

public class BasicClass {

    private String name;

    public BasicClass() {
    }

    public BasicClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BasicClass{" +
                "name='" + name + '\'' +
                '}';
    }


}
