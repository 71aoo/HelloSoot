import ExampleClass.BinarySearch;
import jas.Var;

/**
 * @Author By 71ao
 * @Created Date : 2021/6/23
 */

public class BinarySearchTest {

    public static void main(String[] args) {

        int search = BinarySearch.search(new int[]{23,34,45,47,89,90}, 23);

        System.out.println(search);
    }
}
