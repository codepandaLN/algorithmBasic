package 算法分析;

import java.io.*;
import java.util.Scanner;

public class StatisticsProblem {
    //方法1(暴力求解)
    public void statistics() throws FileNotFoundException {
        int [] a = new int[10];
        int n,i,j,m;

        File f1 = new File(".\\output.txt");
        //D:\Project\IDEA\JAVA\text_01\src\it\com
        PrintWriter p = new PrintWriter(f1);
        File f = new File("D:\\Project\\IDEA\\JAVA\\leedcode\\src\\算法分析\\input.txt");

        //计算程序运行时间，开始计算和计算完成分别计时
        long startTime = System.currentTimeMillis();
        Scanner in = new Scanner(f);
        n = in.nextInt();//把文件中的数据赋给n
        System.out.println("总页数为"+n+"的测试结果");
        for ( i = 1; i <=n; i++) {
            if (i<10)
                a[i]++;

            if(i>=10) {
                j = i;
                while(j != 0) {
                    m = j%10;
                    a[m]++;
                    j = j/10;
                }
            }
        }
        System.out.println("方法一统计数字的结果为：");
        for(i=0;i<10;i++){
            p.println(a[i]);//将结果输出到文件
            System.out.println(a[i]);
        }
        p.close();
        in.close();
        long endTime = System.currentTimeMillis();
        System.out.println("方法一程序运行时间：" + (endTime - startTime) + "ms");
    }


    //方法二：页码规律(补零)
    // 保存最终结果的数组
    private int[] result;

    /**
     * Constructor，初始化结果数组
     */
    public StatisticsProblem() {
        this.result = new int[10];
    }

    /**
     * 求解整数幂
     *
     * @param a 底数
     * @param b 指数
     * @return a的b次方
     */
    public static int power(int a, int b) {
        return (int) Math.pow(a, b);
    }

    /**
     * 用递归来求解所有n位数中每个数字出现的次数
     *
     * @param n 位数
     * @return 10的n次方个n位数中每个数字出现的次数
     */
    public static int func1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        } else {
            return 10 * func1(n - 1) + power(10, n - 1);
        }
    }

    /**
     * 直接使用递推表达式求解所有n位数中每个数字出现的次数
     *
     * @param n 位数
     * @return 10的n次方个n位数中每个数字出现的次数
     */
    public static int func2(int n) {
        return n * power(10, n - 1);
    }

    /**
     * 给定书的总页码的十进制整数，计算每个数字出现的次数
     *
     * @param num 书的总页码整数
     */
    public void statistic(int num) {
        // 获取整数m的位数
        int length = String.valueOf(num).length();
        // 从高位向低位进行统计，再减去多余的0的个数
        long startTime = System.currentTimeMillis();
        for (int i = length; i > 0; i--) {
            // 计算出第i位(从低位向高位)对应的数bitnum
            int a = power(10, i);
            int b = power(10, i - 1);
            int bitnum = (num % a) / b;
            int j;
            // 计算比bitnum小的数字出现的次数
            for (j = 0; j < bitnum; j++) {
                // 计算比bitnum小的数字在第i位出现的次数
                result[j] += b;
                // 当第i位为比bitnum小的数字时，计算所有数字在后面i-1位中出现的次数
                for (int k = 0; k <= 9; k++) {
                    // result[k] += func1(i - 1);
                    result[k] += func2(i - 1);
                }
            }
            // 计算bitnum在第i位出现的次数
            result[j] += num % b + 1;
            // 最后对于数字0需减去多余的0的个数
            result[0] -= b;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("方法二程序运行时间：" + (endTime - startTime) + "ms");
    }

    @SuppressWarnings("resource")
    public static void main(String[] args) throws IOException {
        StatisticsProblem s = new StatisticsProblem();
        s.statistics();

        // 从控制台输入获取书的总页码整数num
        // Scanner scanner = new Scanner(System.in);
        // int num = scanner.nextInt();

        // 从input.txt文本文件中读入书的总页码整数num
        BufferedReader br = new BufferedReader(new FileReader("D:\\Project\\IDEA\\JAVA\\leedcode\\src\\算法分析\\input.txt"));
        int num = Integer.parseInt(br.readLine());

        StatisticsProblem sp = new StatisticsProblem();
        sp.statistic(num);

        // 输出统计结果
        PrintStream ps = new PrintStream(new FileOutputStream("D:\\Project\\IDEA\\JAVA\\leedcode\\src\\算法分析\\output.txt"));
        System.out.println("方法二统计数字的结果为：");
        for (int i = 0; i < 10; i++) {
            // 输出结果到控制台
            System.out.println(sp.result[i]);
            // 输出结果到output.txt文本文档中
            ps.println(sp.result[i]);
        }
        System.out.println("程序运行结束");
    }

}

