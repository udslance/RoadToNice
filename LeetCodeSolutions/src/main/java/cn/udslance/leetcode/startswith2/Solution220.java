package cn.udslance.leetcode.startswith2;



import java.util.ArrayList;
import java.util.List;

/**
 * 存在重复元素 III
 * https://leetcode-cn.com/problems/contains-duplicate-iii/
 * @author H
 * @create 2021-08-10 20:52
 */
public class Solution220 {
    public void test() {
        int[] nums = new int[]{1, 2, 1, 1};

        System.out.println(containsNearbyAlmostDuplicate(nums, 1, 0));
    }

    /**
     * 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，
     * 使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
     *
     * 如果存在则返回 true，不存在返回 false。
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //k 可以理解为窗口大小
        //t 为值差值
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(nums, 0, k, t, path, res);
        return !res.isEmpty();
    }

    private void dfs(int[] nums, int start, int k, int t, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == 2) {
            if (Math.abs(path.get(0) - path.get(1)) <= t) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = start; i <= start + k && i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i + 1, k, t, path, res);
            path.remove(path.size() - 1);
        }
    }
}
