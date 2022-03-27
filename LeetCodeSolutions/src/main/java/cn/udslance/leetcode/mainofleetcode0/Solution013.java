package cn.udslance.leetcode.mainofleetcode0;

/**
 * @author H
 * @create 2021-06-03 10:37
 */
public class Solution013 {

    public static void main(String[] args) {
        String s = "MCMXCIV";

        Solution013 solution013 = new Solution013();

        System.out.println(solution013.romanToInt(s));
    }

    /**
     * 第一版本，最基础
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        //转成字符数组
        char[] chars = s.toCharArray();

        int res = 0;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);


            switch (c) {
                case 'I':
                    if (i + 1 < s.length() || s.charAt(i + 1) == 'V') {
                        res += 4;
                        i++;
                    } else if (i + 1 < s.length() || s.charAt(i + 1) == 'X') {
                        res += 9;
                        i++;
                    } else {
                        res += 1;
                    }
                    break;
                case 'V':
                    res += 5;
                    break;
                case 'X':
                    if (i + 1 < s.length() || s.charAt(i + 1) == 'L') {
                        res += 40;
                        i++;
                    } else if (i + 1 < s.length() || s.charAt(i + 1) == 'C') {
                        res += 90;
                        i++;
                    } else {
                        res += 10;
                    }
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'C':
                    if (i + 1 < s.length() || s.charAt(i + 1) == 'D') {
                        res += 400;
                        i++;
                    } else if (i + 1 < s.length() || s.charAt(i + 1) == 'M') {
                        res += 900;
                        i++;
                    } else {
                        res += 100;
                    }
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'M':
                    res += 1000;
                    break;
                default:
                    break;
            }
        }

        return res;
    }
}
