package cn.udslance.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 * @author H
 * @create 2021-06-06 20:27
 */
class Solution118 {
    public static void main(String[] args) {
        Solution118 solution118 = new Solution118();

        List<List<Integer>> res = solution118.generate(1);

        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }

    public List<List<Integer>> generate(int numRows) {
        //特殊情况
        if (numRows == 0) {
            return null;
        }
        List<List<Integer>> resList = new ArrayList<>();
        //第一行的初始化与入库
        List<Integer> temp1 = new ArrayList<>();
        temp1.add(1);
        resList.add(temp1);
        for (int i = 2; i <= numRows; i++) {
            List<Integer> temp2 = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    //两边的，直接写 1
                    temp2.add(1);
                } else {
                    //中间的，从库中提取
                    int left = resList.get(i - 2).get(j - 1);
                    int right = resList.get(i - 2).get(j);
                    temp2.add(left + right);
                }
            }
            //入库
            resList.add(temp2);
        }
        return resList;
    }
}
