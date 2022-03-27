package cn.udslance.leetcode.mainofleetcode2;

import cn.udslance.beans.TreeNode;


/**
 * 完全二叉树的节点个数
 * https://leetcode-cn.com/problems/count-complete-tree-nodes/
 *
 * @author H
 * @create 2021-08-10 22:25
 */
public class Solution222 {
    private Integer deep = Integer.MAX_VALUE;
    private Integer i = 0;


    public void test() {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        TreeNode root6 = new TreeNode(6);

        root1.left = root2;
        root1.right = root3;

        root2.left = root4;
        root2.right = root5;

        root3.left = root6;

        System.out.println(countNodes(root1));


    }


    public int countNodes(TreeNode root) {
        //一个指针一直往右，找到深度
        if (root.left == null && root.right == null) {
            return 1;
        }

        dfs(root, 1);

        System.out.println("完全树高度：" + deep);
        System.out.println("右边缺少的节点数：" + i);
        return 0;
    }

    public void dfs(TreeNode root, int curDeep) {
        if (root == null) {
            i++;
            return;
        }

        if (root.right != null) {
            dfs(root.right, curDeep + 1);
        } else {
            deep = Math.min(curDeep, deep);
        }

        dfs(root.left, curDeep + 1);
    }


}
