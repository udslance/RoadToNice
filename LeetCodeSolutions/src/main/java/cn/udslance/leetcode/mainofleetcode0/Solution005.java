package cn.udslance.leetcode.mainofleetcode0;

/**
 * @author H
 * @create 2021-06-14 17:01
 */
public class Solution005 {
    public static void main(String[] args) {
        Solution005 solution005 = new Solution005();

        System.out.println(solution005.longestPalindrome("bcbb"));

    }

    public String longestPalindrome(String s) {
        //特殊情况
        if (s.length() == 1) {
            return s;
        }

        String[] dp = new String[s.length()];

        dp[0] = s.substring(0, 1);

        double symmetryAxis = 0.5;

        for (int i = 1; i < s.length(); i++) {
            //(1)i为右侧点，找左侧点

            //情况2：不对称，则移动对称轴，如果一直不对称，会移动到 i 处。
            while (2 * symmetryAxis - i < 0 || s.charAt(i) != s.charAt((int) (2 * symmetryAxis - i))) {
                symmetryAxis += 0.5;
            }

            int left = (int) (2 * symmetryAxis - i);

            String temp = s.substring(left, i + 1);

            if (temp.length() >= dp[i - 1].length()) {
                dp[i] = temp;
            } else {
                dp[i] = dp[i - 1];
            }

        }

        return dp[s.length() - 1];
    }
}
