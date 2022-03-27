package cn.udslance.leetcode.mainofleetcode5;



/**
 * 替换隐藏数字得到的最晚时间
 *
 * 给你一个字符串 time ，格式为 hh:mm（小时：分钟），其中某几位数字被隐藏（用 ? 表示）。
 *
 * 有效的时间为 00:00 到 23:59 之间的所有时间，包括 00:00 和 23:59 。
 *
 * 替换 time 中隐藏的数字，返回你可以得到的最晚有效时间。
 *
 * https://leetcode-cn.com/problems/latest-time-by-replacing-hidden-digits/
 * @author H
 * @create 2021-07-24 19:06
 */
public class Solution1736 {
    
    public void test() {
        System.out.println(maximumTime("1?:22"));
    }


    public String maximumTime(String time) {

        StringBuilder stringBuilder = new StringBuilder();
        int pre = 0;

        for (int i = 0; i < time.length(); i++) {
            if (i == 2) {
                stringBuilder.append(":");
                continue;
            }
            int n = time.charAt(i) - '0';
            if (n < 0 || n > 9) {
                if (i == 0) {
                    int next = time.charAt(1) - '0';
                    if (next > 3 && next <= 9) {
                        n = 1;
                    } else {
                        n = 2;
                    }
                } else if (i == 1) {
                    n = pre == 2 ? 3 : 9;
                } else if (i == 3) {
                    n = 5;
                } else if (i == 4) {
                    n = 9;
                }
            }
            pre = n;
            stringBuilder.append(n);
        }

        return stringBuilder.toString();
    }
}
