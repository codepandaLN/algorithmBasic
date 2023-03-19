package WeeklyMatch.week337;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author panda
 */
public class BeautifulSubsets {
    public int beautifulSubsets(int[] nums, int k) {
        int n = nums.length;
        int[] mask = new int[n];
        int res = 0;
        // 遍历所有子集
        for (int i = 1; i < (1 << n); i++) {
            int len = 0;
            boolean flag = true;
            // 构造当前子集的掩码 mask
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    mask[len++] = nums[j];
                }
            }
            // 判断当前子集是否为美丽子集
            for (int j = 0; j < len && flag; j++) {
                for (int l = j + 1; l < len && flag; l++) {
                    if (Math.abs(mask[j] - mask[l]) == k) {
                        flag = false;
                    }
                }
            }
            if (flag && len > 0) {
                res++;
            }
        }
        return res;
    }


    public int beautifulSubsets2(int[] nums, int k) {
        Arrays.sort(nums);
        return beautifulSubsets(0, new HashMap<>(), nums, k) - 1;
    }

    private int beautifulSubsets(int index, HashMap<Integer, Integer> map, int[] nums, int k) {
        if (index == nums.length) {
            return 1;
        }
        int count = beautifulSubsets(index + 1, map, nums, k);
        if (map.getOrDefault(nums[index] - k, 0) == 0) {
            map.put(nums[index], map.getOrDefault(nums[index], 0) + 1);
            count += beautifulSubsets(index + 1, map, nums, k);
            map.put(nums[index], map.get(nums[index]) - 1);
        }
        return count;
    }

}
