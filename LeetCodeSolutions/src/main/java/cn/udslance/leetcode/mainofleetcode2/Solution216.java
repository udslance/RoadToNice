package cn.udslance.leetcode.mainofleetcode2;



import java.util.ArrayList;
import java.util.List;

/**
 * @author H
 * @create 2021-08-10 20:29
 */
public class Solution216 {
    
    public void test() {
        List<List<Integer>> res = combinationSum3(2, 18);

        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }


    /**
     * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int size = Math.min(n, 9);
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = i + 1;
        }

        dfs(nums, 0, n, k, path, res);

        return res;
    }

    private void dfs(int[] nums,int start, int target,int k, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            if (target == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = start; i < nums.length; i++) {

            if (target - nums[i] < 0) {
                return;
            }

            path.add(nums[i]);

            dfs(nums, i + 1, target - nums[i], k, path, res);

            path.remove(path.size() - 1);
        }
    }
}
