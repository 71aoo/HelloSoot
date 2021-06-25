package ExampleClass;

/**
 * @Author By 71ao
 * @Created Date : 2021/6/23
 */

public class BinarySearch {

    /**
     * @param sortedArr 已排序好数组
     * @param target 要查找的数
     * @return 找到则返回要查找的数，反之，返回-1。
     */
    public static int search(int[] sortedArr, int target){

        if (sortedArr.length == 0 || target < 0) return -1;

        int left = 0;

        int right = sortedArr.length - 1;

        int mid;

        while (left < right){

            mid = (left + right) >> 1;

            if (target > sortedArr[mid]){

                left = mid + 1;

            }else {

                right = mid;
            }
        }

        return sortedArr[left] == target? target : -1;
    }

}
