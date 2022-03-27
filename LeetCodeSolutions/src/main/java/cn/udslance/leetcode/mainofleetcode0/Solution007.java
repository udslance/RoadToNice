package cn.udslance.leetcode.mainofleetcode0;

/**
 * @author H
 * @create 2021-06-03 9:52
 */
public class Solution007 {
    public int reverse(int x) {
        String str = x + "";

        //用来标记正负
        int helper1 = 1;

        if (str.charAt(0) == '-') {
            helper1 = -1;
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '+' || str.charAt(i) == '-') {
                break;
            }

            stringBuilder.append(str.charAt(i));
        }

        String str1 = stringBuilder.toString();

        return helper1 * Integer.parseInt(str1);
    }
}
