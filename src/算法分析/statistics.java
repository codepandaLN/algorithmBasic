package it.com;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


//方法1(暴力求解)
public class statistics {
    public static void main(String[] args) throws FileNotFoundException {
        int [] a = new int[10];
        int n,i,j,m;

        File f1 = new File(".\\output.txt");
        //D:\Project\IDEA\JAVA\text_01\src\it\com
        PrintWriter p = new PrintWriter(f1);
        File f = new File("D:\\Project\\IDEA\\JAVA\\leedcode\\src\\算法分析\\input.txt");

        Scanner in = new Scanner(f);
        n = in.nextInt();//把文件中的数据赋给n

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
        for(i=0;i<10;i++){
            p.println(a[i]);//将结果输出到文件
            System.out.println(a[i]);
        }
        p.close();
        in.close();
        System.out.println("程序运行结束");
    }

}

