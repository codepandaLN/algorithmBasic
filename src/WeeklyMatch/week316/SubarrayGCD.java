package WeeklyMatch.week316;

public class SubarrayGCD {
    public int subarrayGCD(int[] nums, int k) {
        if(nums.length == 1){
            commonFactors(k,nums[0]);
        }

        int[] tmp = new int[nums.length];
        int i = 0;
        for (int x : nums){
            tmp[i++] = commonFactors(k,x);
        }
        int count1 = 0;
        int res = 0;
        for (int j = 0; j < tmp.length; j++) {
            if(tmp[j] == 1){
                count1++;
            }else{
                res += num(count1);
                count1 = 0;
            }

        }
        return res;
    }

    public int num(int x){
        if(x <= 1) {
            return  x;
        }
        return num(x) + num(x-1);
    }

    public int commonFactors(int a, int b) {
        if (a > b) {
            return 0;
        }
        int res = 0;
        int min = a > b ? b : a;

        for (; min > 0; min--) {
            if (a % min == 0 && b % min == 0) {
                res++;
            }
        }
        return res == a ? 1 : 0;
    }
}
