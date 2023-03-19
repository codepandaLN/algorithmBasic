package stack;

import java.util.Stack;

/**
 * @author panda
 * @url https://leetcode.cn/problems/evaluate-reverse-polish-notation/
 */
public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String s : tokens){
            if(s.equals("+")){
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num1+num2);
            }else if(s.equals("-")){
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2 - num1);
            }else if(s.equals("*")){
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2 * num1);
            }else if(s.equals("/")){
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2 / num1);
            }else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
