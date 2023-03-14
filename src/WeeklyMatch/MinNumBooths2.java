package WeeklyMatch;

import java.util.Arrays;

public class MinNumBooths2 {
    public int minNumBooths(String[] demand) {
        int[] num = new int[25];
        int sum = 0;
        String index;

        for (int i = 0; i < demand.length; ++i) {
            index = demand[i];
            int[] temp = new int[25];
            //Arrays.fill(temp, 0);
            for (char c : index.toCharArray()) {
                temp[c - 97]++;
            }
            for (int j = 0; j < 25; ++j) {
                if (temp[j] > num[j]) {
                    num[j] = temp[j];
                }
            }
        }

        for (int i = 0; i < 25; i++) {
            sum += num[i];
        }
        //System.out.println(sum);
        return sum;
    }


    public static void main(String[] args) {
        String[] demand = {"ccluro", "mmjhp", "ln", "ayoqwqtqrh", "m", "luhnsb", "gyyy", "auuksw"};
        MinNumBooths2 s = new MinNumBooths2();
        s.minNumBooths(demand);
    }

}
