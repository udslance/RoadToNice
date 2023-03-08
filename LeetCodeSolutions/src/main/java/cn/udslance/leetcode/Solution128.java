package cn.udslance.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长连续序列
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 * @author H
 * @create 2021-07-25 20:06
 */
class Solution128 {

    @Test
    public void test() {
        int[] ints = new int[]{100,4,200,1,3,2};
        System.out.println(longestConsecutive(ints));
    }


    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 1;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                res = Math.max(res, currentStreak);
            }
        }
        return res;
    }
}
