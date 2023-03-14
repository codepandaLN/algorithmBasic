package 排序算法;

import java.util.Arrays;

public class InsertionSort {
    public int[] insertionSort(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; ++i) {
            int temp = nums[i];
            int j = i;
            while (j > 0 && temp < nums[j - 1]) {
//                nums[j--] = nums[j-1];        ???
                nums[j] = nums[j - 1];
                --j;
            }
            nums[j] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        InsertionSort sort = new InsertionSort();
        int[] res = sort.insertionSort(nums);
        System.out.println(Arrays.toString(res));
    }
}
