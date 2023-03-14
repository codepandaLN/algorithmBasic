package 排序算法;

import java.util.Arrays;

public class QuickSort {
    int[] quickSort(int[] nums, int l, int r) {
        // 子数组长度为 1 时终止递归
        if (l >= r) {
            return nums;
        }
        // 哨兵划分操作
        int i = partition(nums, l, r);
        // 递归左（右）子数组执行哨兵划分
        quickSort(nums, l, i - 1);
        quickSort(nums, i + 1, r);
        return nums;
    }

    int partition(int[] nums, int l, int r) {
        // 以 nums[l] 作为基准数
        int i = l, j = r;
        while (i < j) {
            while (i < j && nums[j] >= nums[l]) {
                j--;
            }
            while (i < j && nums[i] <= nums[l]) {
                i++;
            }
            swap(nums, i, j);
        }
        swap(nums, i, l);
        return i;
    }

    void swap(int[] nums, int i, int j) {
        // 交换 nums[i] 和 nums[j]
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public static void main(String[] args) {
        System.out.println("快速排序时间复杂度为O(nlogn)");
        System.out.println("快速排序空间复杂度为O(logn)");
        int[] test1 = {1,2,3,4,5,6,7};
        int[] test2 = {5,5,2,35,66,87,22,5,9};
        int[] test3 = {8,6,9,88,55,21,99,10,21,33};
        int[] test4 = {5, 2, 3, 1, 4, 6,0};

        QuickSort sort = new QuickSort();
        int[] res1 = sort.quickSort(test1,0,test1.length-1);
        int[] res2= sort.quickSort(test2,0,test2.length-1);
        int[] res3 = sort.quickSort(test3,0,test3.length-1);
        int[] res4 = sort.quickSort(test4,0,test4.length-1);

        System.out.println("测试数据text1的结果为：");
        System.out.println(Arrays.toString(res1));

        System.out.println("测试数据text2的结果为：");
        System.out.println(Arrays.toString(res2));


        System.out.println("测试数据text3的结果为：");
        System.out.println(Arrays.toString(res3));


        System.out.println("测试数据text4的结果为：");
        System.out.println(Arrays.toString(res4));

    }
}
