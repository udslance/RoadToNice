package cn.udslance.leetcode.mainofleetcode5;



/**
 * 平方数之和
 * https://leetcode-cn.com/problems/sum-of-square-numbers/
 * @author H
 * @create 2021-08-23 9:21
 */
public class Solution633 {

    public void test() {
        System.out.println(judgeSquareSum(1));
    }

    public boolean judgeSquareSum(int c) {
        int left = 0, right = (int) Math.sqrt(c);
        while (left <= right) {
            int res = left * left + right * right;

            if (res == c) {
                return true;
            }
            if (res < c) {
                left++;
            } else {
                right --;
            }
        }
        return false;
    }
}
