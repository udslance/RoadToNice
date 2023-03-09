package cn.udslance.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @title: 所有可能的路径
 * @description: 给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
 * @difficulty: Medium
 * @Link: <a href="https://leetcode.cn/problems/all-paths-from-source-to-target/description/?orderBy=most_votes">link</a>
 * @author: Udslance
 * @create: 2023-02-26 21:16
 **/
class Solution797 {
    int[][] g;
    int n;
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        g = graph;
        n = g.length;
        cur.add(0);
        dfs(0);
        return ans;
    }
    void dfs(int u) {
        if (u == n - 1) {
            ans.add(new ArrayList<>(cur));
            return ;
        }
        for (int next : g[u]) {
            cur.add(next);
            dfs(next);
            cur.remove(cur.size() - 1);
        }
    }
}
