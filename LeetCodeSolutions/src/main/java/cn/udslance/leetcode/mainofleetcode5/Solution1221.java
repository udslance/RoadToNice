package cn.udslance.leetcode.mainofleetcode5;


/**
 * @author H
 * @create 2021-08-23 9:21
 */
public class Solution1221 {
    public int balancedStringSplit(String s) {
        int d = 0;
        int res = 0;

        for (char c : s.toCharArray()) {
            if (c == 'L') {
                ++d;
            } else {
                --d;
            }
            if (d == 0) {
                ++res;
            }
        }

        return res;

    }

    
    public void test() {
        long startTime = System.currentTimeMillis();
        //do something
        System.out.println(balancedStringSplit("RLRRRLLRLL"));
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
}
