package WeeklyMatch.week315;

import java.util.HashSet;

public class CountDistinctIntegers {
    public static int countDistinctIntegers(int[] nums) {
        int n = nums.length;
        int res = 0;
        //int[] tmp = new int[2*n];
        HashSet<Integer> set = new HashSet<Integer>();
        //res = Arrays.copyOf(nums,n);
        for (int i = 0; i < n; i++) {
            //tmp[i] = nums[i];
            set.add(nums[i]);
        }
        for (int i = 0; i < n; i++) {
            //tmp[n++] = reverse(nums[i]);
            set.add(reverse(nums[i]));
        }
        return set.size();
    }

    public static int reverse(int number) {
        int res=0;
        while(number > 0) {
            res *= 10;
            res += number % 10;
            number /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int a = 10;
        System.out.println(CountDistinctIntegers.reverse(a));
    }

}
