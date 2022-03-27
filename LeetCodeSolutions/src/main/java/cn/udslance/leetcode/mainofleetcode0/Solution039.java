package cn.udslance.leetcode.mainofleetcode0;



import java.util.ArrayList;
import java.util.List;

/**
 * @author H
 * @create 2021-06-29 23:14
 */
public class Solution039 {
    
    public void test() {
        List<List<Integer>> res = combinationSum(new int[]{2, 3,6,7}, 7);

        for (List<Integer> re : res) {
            System.out.println(re);
        }

    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();



        dfs(candidates, 0, target, res, path);


        return res;
    }

    public void dfs(int[] candidates, int start, int target, List<List<Integer>> res, List<Integer> path) {
        // target 为负数和 0 的时候不再产生新的孩子结点
        if (target < 0) {
            return;
        }
        //终止条件
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }


        // 重点理解这里从 begin 开始搜索的语意
        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
            dfs(candidates, i, target - candidates[i], res, path);
            // 状态重置
            path.remove(path.size() - 1);
        }

    }
}
