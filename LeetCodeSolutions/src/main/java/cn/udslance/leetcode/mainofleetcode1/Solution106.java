package cn.udslance.leetcode.mainofleetcode1;


import cn.udslance.beans.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author H
 * @create 2021-07-22 19:51
 */
public class Solution106 {

    public void test() {
        buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
    }

    private Map<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder,int[] postorder) {
        int n = inorder.length;
        //使用哈希表来帮助我们快速地定位根节点
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(inorder, postorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd,  int postStart, int postEnd) {
        if (postStart > postEnd) {
            return null;
        }
        //从后序遍历序列的末尾中找到根节点的 值
        int rootVal = postorder[postEnd];
        //从中序遍历序列中找到根节点的 位置
        int rootLoc = map.get(rootVal);
        //根节点位置之前的即为左子树，根节点右边的即为右子树
        //计算左子树节点个数
        int leftSize = rootLoc - inStart;
        //搭建根节点
        TreeNode root = new TreeNode(rootVal);
        //递归搭建左子树
        root.left = helper(inorder, postorder, inStart, rootLoc - 1, postStart, postStart + leftSize - 1);
        //递归搭建右子树
        root.right = helper(inorder, postorder, rootLoc + 1, inEnd, postStart  + leftSize, postEnd - 1);

        return root;

    }
}
