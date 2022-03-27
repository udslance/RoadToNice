package cn.udslance.leetcode.mainofleetcode1;

import cn.udslance.beans.TreeNode;


/**
 * 求根节点到叶节点数字之和
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 * @author H
 * @create 2021-07-25 20:45
 */
public class Solution129 {

    public void test() {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);

        root1.left = root2;
        root1.right = root3;

        System.out.println(sumNumbers(root1));
    }


    /**
     * 结果
     */
    private Integer res = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int cur) {
        //终止条件：已到达叶子节点
        if (root.left == null && root.right == null) {
            //记录结果之前记得把叶子节点加上
            int temp = cur * 10 + root.val;
            res += temp;
            return;
        }
        //递归左子树
        if (root.left != null) {
            dfs(root.left, cur * 10 + root.val);
        }
        //递归右子树
        if (root.right != null) {
            dfs(root.right, cur * 10 + root.val);
        }
    }
}
