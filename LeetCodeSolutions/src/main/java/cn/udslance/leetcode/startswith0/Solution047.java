package cn.udslance.leetcode.startswith0;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author H
 * @create 2021-07-01 23:24
 */
public class Solution047 {


    public void test() {
        List<List<Integer>> res = permuteUnique(new int[]{1,2,3});

        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        boolean[] used = new boolean[nums.length];

        List<Integer> path = new ArrayList<>();

        //给数组排序
        Arrays.sort(nums);

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

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
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
