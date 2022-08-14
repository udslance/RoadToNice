package cn.udslance.leetcode.startswith5;

import cn.udslance.beans.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author H
 * @create 2021-08-23 9:21
 */
public class Solution654 {
    /**
     * key：值
     * value：地址
     */
    Map<Integer, Integer> helpMap = new HashMap<>();

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            helpMap.put(nums[i], i);
        }

        return cons(nums, 0, nums.length - 1);
    }

    private TreeNode cons(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        //首先要找到区间的最大值以及地址，作为本次递归的根节点，之后返回
        int max = Integer.MIN_VALUE;
        for (int i = start; i < end + 1; i++) {
            max = Math.max(max, nums[i]);
        }
        int maxLoc = helpMap.get(max);
        TreeNode root = new TreeNode(max);
        //从 start 到 maxLoc - 1 将作为左子树
        root.left = cons(nums, start, maxLoc - 1);
        //从 macLoc + 1 到 end 将作为右子树
        root.right = cons(nums, maxLoc + 1, end);

        return root;
    }


    
    public void test() {
        long startTime = System.currentTimeMillis();
        //do something
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
}
