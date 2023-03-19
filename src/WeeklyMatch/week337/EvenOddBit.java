package WeeklyMatch.week337;

/**
 * @author panda
 * @url https://leetcode.cn/problems/number-of-even-and-odd-bits/description/
 */
public class EvenOddBit {
    public int[] evenOddBit(int n) {
        int even = 0, odd = 0;
        // 遍历 n 的二进制形式中的每一位
        for (int i = 0; i < 32; i++) {
//            使用 n & 1 得到二进制末尾是否为 1；
//            把 n 右移 1 位，直至结束。
//            (n >> i) & 1  =>  n & 1 ; n = n >> 1
            int bit = (n >> i) & 1;
            // 如果当前位为偶数下标的 1，则 even++
            if (i % 2 == 0 && bit == 1) {
                even++;
            }
            // 如果当前位为奇数下标的 1，则 odd++
            if (i % 2 == 1 && bit == 1) {
                odd++;
            }
        }
        return new int[]{even, odd};
    }
}
