package cn.udslance.leetcode.startswith3;

import cn.udslance.beans.TreeNode;

/**
 * @author H
 * @create 2021-08-22 19:01
 */
public class Solution337 {
    public int rob(TreeNode root) {
        int[] result = robInternal(root);
        // 把偷不偷根节点分为两种情况比较，选最优情况
        return Math.max(result[0], result[1]);
    }

    public int[] robInternal(TreeNode root) {
        if (root == null) {
            //终止条件，到达叶子节点。
            return new int[2];
        }
        int[] result = new int[2];

        int[] left = robInternal(root.left);
        int[] right = robInternal(root.right);

        // 0：表示不偷当前节点，那么两个子节点都可以选择偷或不偷，选最优即可
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 1：表示偷当前节点，那么两个子节点都不能偷
        result[1] = left[0] + right[0] + root.val;

        return result;
    }
}
