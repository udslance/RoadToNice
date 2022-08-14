package cn.udslance.leetcode.startswith5;



/**
 * @author H
 * @create 2021-08-23 9:21
 */
public class Solution1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] difference = new int[n];
        for (int i = 0; i < n; i++) {
            difference[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        //最长子序列，和不大于 maxCost
        //滑动窗口法
        int l = -1;
        int sum = 0;
        int res = 0;
        for (int r = 0; r < n; r++) {
            sum += difference[r];

            if (sum > maxCost) {
                sum -= difference[++l];
            } else {
                res = Math.max(res, r - l);
            }
        }
        return res;
    }



    public void test() {
        long startTime = System.currentTimeMillis();
        //do something
        System.out.println(equalSubstring("abcd", "acde", 0));

        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
}
