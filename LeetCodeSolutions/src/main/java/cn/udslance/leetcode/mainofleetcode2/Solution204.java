package cn.udslance.leetcode.mainofleetcode2;

import java.util.Arrays;

/**
 * @author H
 * @create 2021-06-10 20:00
 */
public class Solution204 {
    public static void main(String[] args) {

    }

    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];

        Arrays.fill(isPrime, true);

        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                for (int j = i; j < n; j += n) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;

        for (boolean b : isPrime) {
            if (b) {
                count++;
            }
        }

        return count;
    }
}
