package WeeklyMatch;

public class FindArray {
    public int[] findArray(int[] pref) {
        if (pref.length == 1) {
            return pref;
        }

        int n = pref.length;
        int[] ans = new int[n];
        ans[0] = pref[0];
        for (int i = 1; i < n; i++) {
            ans[i] = pref[i] ^ pref[i - 1];
        }
        return ans;
    }
}


