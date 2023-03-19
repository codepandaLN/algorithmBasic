package WeeklyMatch.week337;

/**
 * @author panda
 */
public class FindSmallestInteger {
    public int findSmallestInteger(int[] nums, int value) {
        int[] count = new int[value];
        for (int num : nums) {
            count[(num % value + value) % value]++;
        }
        for (int i = 0;; i++) {
            if (--count[i % value] < 0) {
                return i;
            }
        }
    }
}
