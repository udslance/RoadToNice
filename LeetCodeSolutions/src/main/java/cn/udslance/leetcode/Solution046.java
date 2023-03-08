package cn.udslance.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author H
 * @create 2021-07-01 23:24
 */
class Solution046 {

    
    public void test() {
        List<List<Integer>> res = permute(new int[]{0,1});

        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        boolean[] used = new boolean[nums.length];

        List<Integer> path = new ArrayList<>();

        dfs(nums, used, res, path);

        return res;
    }


    private void dfs(int[] nums,boolean[] used, List<List<Integer>> res, List<Integer> path) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            used[i] = true;

            path.add(nums[i]);

            dfs(nums, used, res, path);

            path.remove(path.size() - 1);

            used[i] = false;
        }
    }
}
