package linked_list;

import java.util.Stack;

/**
 * @author panda
 * @url https://leetcode.cn/problems/validate-stack-sequences/
 */
public class ValidateStackSequences {
    //值不重复
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        //记录popped数组访问到哪一个元素了
        int index = 0;
        for (int num:pushed) {
            stack.push(num);

            while (!stack.isEmpty() && stack.peek() == popped[index]){
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
}
