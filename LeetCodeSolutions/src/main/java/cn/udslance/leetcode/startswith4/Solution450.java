package cn.udslance.leetcode.startswith4;

import cn.udslance.beans.TreeNode;


/**
 * @author H
 * @create 2021-08-23 9:21
 */
public class Solution450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        // 如果当前节点值大于目标值，则需要到左子树中去搜索
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        // 如果当前节点值大于目标值，则需要到左子树中去搜索
        else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        // 如果当前节点值等于目标值，则需要进行删除操作
        else {
            //如果当前节点没有左子树，则直接将右子树接上
            if (root.left == null) {
                return root.right;
            }

            //如果当前节点没有右子树，则直接将左子树接上
            if (root.right == null) {
                return root.left;
            }

            //如果既有左子树又有右子树
            // 根据二叉搜索树的特点，左子树中数值无论如何也比右子树小
            // 所以将左子树接在右子树的最小节点上
            // 首先找到右子树的最小节点
            TreeNode tmpNode1 = root.right;
            while (tmpNode1.left != null) {
                tmpNode1 = tmpNode1.left;
            }
            //然后将左子树接在右子树的最小节点上
            tmpNode1.left = root.left;
            return root.right;

        }
        return root;
    }




    
    public void test() {
        long startTime = System.currentTimeMillis();
        //do something
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
}
