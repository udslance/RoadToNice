package cn.udslance.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author H
 * @create 2021-07-16 15:40
 */
class Solution078 {
    public void test() {
        List<List<Integer>> res = subsets(new int[]{1,2,3});
        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 1; i <= nums.length; i++) {
            helper(nums, 0, i, path, res);
        }
        return res;
    }

    private void helper(int[] ints,int start, int k, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
        }
        for (int i = start; i < ints.length; i++) {
            path.add(ints[i]);
            helper(ints, i + 1, k, path, res);
            path.remove(path.size() - 1);
        }
    }
}
