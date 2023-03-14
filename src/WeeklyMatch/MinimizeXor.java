package WeeklyMatch;

public class MinimizeXor {
    public int minimizeXor(int num1, int num2) {
        int a = getNum(num1);
        int b = getNum(num2);
        //int b = Integer.bitCount(num2) + 1;
        int res = num1;
        if(b < a){
            num1 &= num1 - 1;  //1 变成 0
            b += 1;
            res = ~num1;
        }else if(b > a){
            num1 |= res & - res; // 0 变成 1
            res &= res - 1;
            b -= 1;
        }
        return res;
    }

    private static int getNum(int i) {
        int count = 0;
        while (i > 0) {
            i=i&(i-1);
            count++;

            i = i >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        MinimizeXor s = new MinimizeXor();
        int res = s.minimizeXor(1,12);
        System.out.println(res);

    }

}
