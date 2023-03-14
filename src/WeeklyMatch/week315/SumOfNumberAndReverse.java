package WeeklyMatch.week315;

public class SumOfNumberAndReverse {
    public boolean sumOfNumberAndReverse(int num) {
        if(num == 0){
            return true;
        }
        if(num == 1){
            return false;
        }

        //int tmp = num;
        for (int i = num; i <= (num+1)/2; i--) {
            if(i + reverse(i) == num){
                return true;
            }
        }
        return false;
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

}
