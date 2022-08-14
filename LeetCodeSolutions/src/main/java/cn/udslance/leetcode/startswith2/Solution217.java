package cn.udslance.leetcode.startswith2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author H
 * @create 2021-06-10 21:06
 */
public class Solution217 {
    public boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        return set.size() == nums.length;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        for (int i = 0; i < nums.length -1; i++) {

            for (int j = i + 1;j < i + k + 1 && j < nums.length; j++) {
                if (nums[j] - nums[i] == 0 && j - i <= k) {
                    return true;
                }
            }

        }

        return false;

    }

}
