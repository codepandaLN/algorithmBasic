package 排序算法;

import java.util.Arrays;

public class MergeSort {
    public int[] mergeSort(int[] nums, int[] tmp, int low, int high) {
        if (low == high) {
            return nums;
        }

        int mid = (low+high)/2;
        mergeSort(nums, tmp, low, mid);
        mergeSort(nums, tmp, mid + 1, high);
        merge(nums,tmp, low, mid + 1, high);
        return nums;
    }

    private void merge(int[] nums,int[] tmp, int low, int mid, int high) {
        int i = low, j = mid, k = 0;

        while (i < mid && j <= high) {
            if (nums[i] < nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
            }
        }
        while (i < mid) {
            tmp[k++] = nums[i++];
        }
        while (j <= high) {
            tmp[k++] = nums[j++];
        }
        for (i = 0, k = low; k <= high; ) {
            nums[k++] = tmp[i++];
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1,12,15,11,30};
        int h = nums.length;
        int[] tmp = new int[h];
        MergeSort sort = new MergeSort();
        int[] res= sort.mergeSort(nums,tmp,0,h-1);
        System.out.println("合并排序的结果是：");
        System.out.println(Arrays.toString(res));
    }
}
