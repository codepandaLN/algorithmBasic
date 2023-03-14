package WeeklyMatch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class MinNumBooths {
    public  int minNumBooths(String[] demand) {
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap();
        for(String str : demand) {
            HashMap<Character, Integer> tempMap = new HashMap();
            for(int i = 0;i<str.length();i++) {
                char c = str.charAt(i);
                if(tempMap.get(c) == null)
                    tempMap.put(c,1);
                else tempMap.put(c, tempMap.get(c)+1);
                if (map.get(c) == null) {
                    map.put(c,1);
                    ans++;
                }
                else {
                    if (tempMap.get(c) > map.get(c)) {
                        ans += (tempMap.get(c) - map.get(c));
                        map.put(c, tempMap.get(c));
                    }
                }
            }
        }
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        String[] demand = {"ccluro","mmjhp","ln","ayoqwqtqrh","m","luhnsb","gyyy","auuksw"};

        MinNumBooths s = new MinNumBooths();

        s.minNumBooths(demand);
    }

}
