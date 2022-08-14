package cn.udslance.leetcode.startswith2;

/**
 * @author H
 * @create 2021-06-12 7:55
 */
public class Solution231 {
    public static void main(String[] args) {
        Solution231 solution231 = new Solution231();

        System.out.println(solution231.isPowerOfTwo(8));

    }

    public boolean isPowerOfTwo(int n) {

        if (n == 0) {
            return false;
        }

        if (n == 1) {
            return true;
        }

        while (n != 1) {
            if (n % 2 != 0) {
                return false;
            }

            n /= 2;
        }

        return true;
    }
}
