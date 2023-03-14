package Test;

import java.util.Arrays;

public class Test {

   public static int[] SelecSort(int[] nums){
       int n = nums.length;
       int minIndex = 0;
       for (int i = 0; i < n-1; i++) {
           minIndex = i;
           for (int j = i + 1; j < n; j++) {
//               if(nums[minIndex] > nums[j]){
//                   minIndex = j;
//               }
             minIndex = nums[minIndex] > nums[j] ? j : minIndex;
           }
           swap(nums,minIndex,i);
       }
       return nums;
   }

    private static void swap(int[] nums, int i, int j) {
       int temp = nums[i];
       nums[i] = nums[j];
       nums[j] = temp;

    }


    public static void main(String[] args) {
        int[] nums = {5,6,9,2,7};
        System.out.println(Arrays.toString(Test.SelecSort(nums)));

    }

}
