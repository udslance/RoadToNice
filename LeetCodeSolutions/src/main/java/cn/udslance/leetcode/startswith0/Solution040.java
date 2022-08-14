package cn.udslance.leetcode.startswith0;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author H
 * @create 2021-06-29 23:14
 */
public class Solution040 {
    
    public void test() {
        List<List<Integer>> res = combinationSum2(new int[]{2,5,2,1,2}, 5);

        for (List<Integer> re : res) {
            System.out.println(re);
        }

    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        Arrays.sort(candidates);

        boolean[] booleans = new boolean[candidates.length];


        dfs(candidates, 0, target, res, path, booleans);


        return res;
    }

    public void dfs(int[] candidates, int start, int target, List<List<Integer>> res, List<Integer> path, boolean[] used) {
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
            /*
             * 在什么条件下跳过这次循环？
             * 1. 当前起始数字跟他前一位一样
             * 2. 他前一位作为路径起点的情况已经讨论过了
             * 3. 参考题目“字符串的题目”
             */
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;

            path.add(candidates[i]);
            // 注意：不能重复使用
            dfs(candidates, i + 1, target - candidates[i], res, path, used);
            // 状态重置
            path.remove(path.size() - 1);

            used[i] = false;
        }

    }
}
