package WeeklyMatch;

public class CommonFactors {
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

    public static void main(String[] args) {
        CommonFactors s = new CommonFactors();
        int res = s.commonFactors(12, 6);
        System.out.println(res);

    }

}