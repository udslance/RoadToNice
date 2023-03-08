package cn.udslance.leetcode;

/**
 * 验证回文串
 * @author H
 * @create 2021-06-08 15:22
 */
class Solution125 {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        Solution125 solution125 = new Solution125();
        boolean b = solution125.isPalindrome(s);
        System.out.println(b);
    }

    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        //全部转为小写
        s = s.toLowerCase();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) > 96 && s.charAt(i) < 123) || (s.charAt(i) > 47 && s.charAt(i) < 58)) {
                stringBuilder.append(s.charAt(i));
            }
        }
        s = stringBuilder.toString();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
