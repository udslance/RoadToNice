package cn.udslance.leetcode;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @title: 子集 II
 * @description: 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * @difficulty: Medium
 * @Link: <a href="https://leetcode.cn/problems/subsets-ii/description/">link</a>
 * @author: Udslance
 * @create: 2022-10-16 11:40
 **/
class Solution090 {

    private static final Logger LOGGER = Logger.getLogger("");

    @Test
    public void testUrAnswer() {
        long startTime = System.currentTimeMillis();

        // do something!
        List<List<Integer>> res = subsetsWithDup(new int[]{1, 2, 2});

        LOGGER.info("运行结果：" + res.toString());
        // end
        long endTime = System.currentTimeMillis();
        LOGGER.info("程序运行时间：" + (endTime - startTime) + " ms");
    }

    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(false, 0, nums);
        return ans;
    }

    public void dfs(boolean choosePre, int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        dfs(false, cur + 1, nums);
        if (!choosePre && cur > 0 && nums[cur - 1] == nums[cur]) {
            return;
        }
        t.add(nums[cur]);
        dfs(true, cur + 1, nums);
        t.remove(t.size() - 1);
    }
}
