package cn.udslance.leetcode.startswith5;



import java.util.Stack;

/**
 * @author H
 * @create 2021-08-23 9:21
 */
public class Solution1190 {

    public String reverseParentheses(String s) {
        //维护两个栈，一个放括号，一个放字符串
        char[] chars = s.toCharArray();

        Stack<Character> bracketStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder cur = new StringBuilder();

        for (char aChar : chars) {
            if (aChar == '(') {
                bracketStack.push(aChar);
                stringStack.push(cur);
                cur = new StringBuilder();
                continue;
            }

            if(aChar == ')'){
                cur.reverse();
                cur = stringStack.pop().append(cur);
                continue;
            }

            cur.append(aChar);
        }

        return cur.toString();
    }


    
    public void test() {
        long startTime = System.currentTimeMillis();
        //do something
        System.out.println(reverseParentheses("(ed(et(oc))el)"));
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + " ms");
    }
}
