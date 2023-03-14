package WeeklyMatch.week315;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindMaxK {
    public int findMaxK(int[] nums) {
        //Arrays.sort(nums);
        int res = -1;
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            int temp = -1;
            if (hashtable.containsKey(-nums[i])) {
                temp = Math.abs(nums[hashtable.get(-nums[i])]);
            }
            res = Math.max(res,temp);
            hashtable.put(nums[i], i);
        }
        return res;
    }
}
