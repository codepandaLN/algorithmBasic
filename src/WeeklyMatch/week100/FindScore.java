package WeeklyMatch.week100;

import java.util.Arrays;

/**
 * @author panda
 */
public class FindScore {
    public long findScore(int[] nums) {
        int n = nums.length;
        boolean[] used = new boolean[n];
        Arrays.fill(used, false);

        int index = 0;
        int score = 0;

        for ( int j = 0; j < n; ++j) {
            int min = Integer.MAX_VALUE;
            while(used[j] == false){


            for (int i = 0; i < n-1  ; i++) {
                if(min > nums[i]){
                    min = nums[i];
                    index = i;
                }
            }
            // 如果当前数未被标记
            if (!used[index]) {
                // 将其加入分数中
                score += nums[index];
                // 标记当前数
                used[index] = true;
                // 标记左侧相邻元素
                if (index > 0 && !used[index - 1]) {
                    used[index - 1] = true;
                }
                // 标记右侧相邻元素
                if (index < n - 1 && !used[index + 1]) {
                    used[index + 1] = true;
                }
            }
            }

        }
        return score;
    }
}
