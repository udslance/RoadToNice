package cn.udslance.leetcode.startswith5;



import java.util.Stack;

/**
 * @author H
 * @create 2021-08-17 19:54
 */
public class Solution551 {
    
    public void test() {
        boolean res = checkRecord("PPALLL");
        System.out.println(res);
    }

    public boolean checkRecord(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> characterStack = new Stack<>();
        int a = 0;
        for (int i = 0; i < chars.length && a < 2 && characterStack.size() < 3; i++) {
            if (chars[i] == 'P') {
                characterStack.clear();
            }

            if (chars[i] == 'A') {
                ++a;
            }

            if (chars[i] == 'L') {
                characterStack.push('L');
            }
        }


        return a < 2 && characterStack.size() < 3;
    }
}
