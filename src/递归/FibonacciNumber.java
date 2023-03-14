package 递归;

public class FibonacciNumber {
    //暴力递归 时间复杂度指数级别
    public int method1(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return method1(n - 1) + method1(n - 2);
    }

    //动态规划 比较暴力递归优化了时间复杂度（O（n））
    public int method2(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    //继续优化空间复杂度；可以用滑动数组加动态规划的方法
    public int method3(int n) {
        if (n <= 1) {
            return n;
        }
        int pre = 0, cur = 1, res = 0;
        for (int i = 2; i <= n; i++) {
            res = pre + cur;
            pre = cur;
            cur = res;
        }
        return res;
    }

    //矩阵快速幂
    public int method4(int n) {
        if (n < 2) {
            return n;
        }
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n - 1);
        return res[0][0];
    }

    public int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }

    public int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }

    //通项公式
    public int method5(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibN = Math.pow((1 + sqrt5) / 2, n) - Math.pow((1 - sqrt5) / 2, n);
        return (int) Math.round(fibN / sqrt5);
    }

    public static void main(String[] args) {
        FibonacciNumber demo1 = new FibonacciNumber();
        System.out.println("方法一：暴力递归(时间复杂度指数级别）");
        System.out.println(demo1.method1(9));
        System.out.println("方法二：动态规划 比较暴力递归优化了时间复杂度（O（n））");
        System.out.println(demo1.method2(9));
        System.out.println("方法三：用滑动数组加动态规划的方法继续优化空间复杂度；");
        System.out.println(demo1.method3(9));
        System.out.println("方法四：矩阵快速幂，时间复杂度：O(logn)");
        System.out.println(demo1.method4(9));
        System.out.println("方法五：通项公式");
        System.out.println(demo1.method5(9));


    }
}
