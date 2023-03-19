package Test;

import java.util.Stack;

/**
 * @author panda
 */
public class IsPalindrome {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int num = x;
        int cur = 0;
        while (num > 0) {
            cur = cur * 10 + num % 10;
            num /= 10;
        }
        return x == cur;
    }
}
