package cn.udslance.leetcode.mainofleetcode0;

/**
 * @author H
 * @create 2021-06-16 8:57
 */
public class Solution008 {
    public static void main(String[] args) {
        Solution008 solution008 = new Solution008();

        System.out.println(solution008.myAtoi("-2147483649"));

    }

    public int myAtoi(String s) {


        //读入字符串并丢弃无用的前导空格
        char[] chars = s.trim().toCharArray();

        if (chars.length == 0) {
            return 0;
        }

        //用flag来标记正负
        //用start来标记遍历起点，默认有正负号，所以默认值为1
        int flag = 1;
        int start = 1;
        if (chars[0] == '-') {
            flag = -1;
        } else if (chars[0] != '+') {
            start = 0;
        }

        int res = 0;

        while (start < chars.length && chars[start] >= '0' && chars[start] <= '9') {
            int cur = chars[start++] - '0';

            if (res * flag > 214748364 || (res * flag == 214748364 && cur > 7)) {
                return Integer.MAX_VALUE;
            } else if (res * flag < -214748364 || (res * flag == -214748364 && cur > 7)) {
                return Integer.MIN_VALUE;
            }

            res = res * 10 + cur;
        }

        return res * flag;
    }

}
