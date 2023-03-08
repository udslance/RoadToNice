package cn.udslance.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author H
 * @create 2021-07-16 15:19
 */
class Solution077 {

    
    public void test() {
        List<List<Integer>> res = combine(4, 2);

        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }


    public List<List<Integer>> combine(int n, int k) {

        List<Integer> path = new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();

        int[] ints = new int[n];

        for (int i = 0; i < ints.length; i++) {
            ints[i] = i + 1;
        }
        helper(ints, 0, k, path, res);

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
