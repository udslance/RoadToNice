package cn.udslance.leetcode.mainofleetcode2;



import cn.udslance.beans.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author H
 * @create 2021-06-13 10:44
 */
public class Solution257 {
    List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.right = treeNode5;

        Solution257 solution257 = new Solution257();


        System.out.println(solution257.binaryTreePaths((treeNode1)));
    }

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();

        binaryTreePathsHelper(root, stringBuilder);

        return res;
    }

    private void binaryTreePathsHelper(TreeNode root, StringBuilder stringBuilder) {
        //终止条件
        if (root == null) {
            return;
        }

        //如果是根节点
        if (stringBuilder.length() == 0) {
            stringBuilder.append(root.val);
        } else {
            stringBuilder.append("->" + root.val);
        }

        if (root.left == null && root.right == null) {
            res.add(stringBuilder.toString());

            return;
        }

        if (root.left != null) {
            binaryTreePathsHelper(root.left, stringBuilder);
            stringBuilder.delete(stringBuilder.length() - 3, stringBuilder.length());
        }


        if (root.right != null) {
            binaryTreePathsHelper(root.right, stringBuilder);
            stringBuilder.delete(stringBuilder.length() - 3, stringBuilder.length());
        }

    }

    
}
