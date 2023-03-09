package cn.udslance.leetcode;
import cn.udslance.beans.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @title: 从前序与中序遍历序列构造二叉树
 * @description: 给定一个二叉树，找出其最大深度。
 * @difficulty: Medium
 * @Link: <a href="https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">link</a>
 * @author: Udslance
 * @create: 2022-09-25 22:38
 **/
class Solution105 {
    public void test() {
        buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }

    private Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        //使用哈希表来帮助我们快速地从中序遍历中定位根节点
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, n - 1, inorder, 0, n - 1);
    }

    private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        //终止条件
        if (preStart > preEnd) {
            return null;
        }
        //从前序遍历序列中找到根节点的 值
        int rootVal = preorder[preStart];
        //从中序遍历序列中找到根节点的 位置
        int rootLoc = map.get(rootVal);
        //根节点位置之前的即为左子树，根节点右边的即为右子树
        //计算左子树节点个数
        int leftSize = rootLoc - inStart;
        //搭建根节点
        TreeNode root = new TreeNode(rootVal);
        //递归搭建左子树
        root.left = helper(preorder, preStart + 1, preStart + leftSize, inorder, inStart, rootLoc - 1);
        //递归搭建右子树
        root.right = helper(preorder, preStart + leftSize + 1, preEnd, inorder, rootLoc + 1, inEnd);
        return root;
    }
}
