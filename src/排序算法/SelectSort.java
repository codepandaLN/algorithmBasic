package 排序算法;

import java.util.Arrays;

public class SelectSort {
    public int[] Selectsort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; ++i) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
        return nums;
    }

    private void swap(int[] nums, int i, int minIndex) {
        int temp = nums[i];
        nums[i] = nums[minIndex];
        nums[minIndex] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        SelectSort sort = new SelectSort();
        int[] res = sort.Selectsort(nums);
        System.out.println(Arrays.toString(res));
    }
}

