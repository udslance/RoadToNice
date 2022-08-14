package cn.udslance.leetcode.startswith1;

import java.util.Stack;

/**
 * @author H
 * @create 2021-08-01 19:30
 */
public class Solution150 {
    public static void main(String[] args) {
        Solution150 solution150 = new Solution150();

        String[] strings = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(solution150.evalRPN(strings));

    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if ("+".equals(token)) {
                int right = stack.pop();
                int left = stack.pop();
                stack.push(left + right);
            } else if ("-".equals(token)) {
                int right = stack.pop();
                int left = stack.pop();
                stack.push(left - right);
            } else if ("*".equals(token)) {
                int right = stack.pop();
                int left = stack.pop();
                stack.push(left * right);
            } else if ("/".equals(token)) {
                int right = stack.pop();
                int left = stack.pop();
                stack.push(left / right);
            } else {
                //是数字
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.peek();
    }
}
