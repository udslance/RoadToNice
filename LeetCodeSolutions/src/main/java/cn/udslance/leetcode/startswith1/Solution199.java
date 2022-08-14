package cn.udslance.leetcode.startswith1;


import cn.udslance.beans.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的右视图
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 * @author H
 * @create 2021-08-08 22:38
 */
public class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> resList = new ArrayList<>(5);

        //特殊情况
        if (root == null) {
            return resList;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            resList.add(queue.getFirst().val);

            int count = queue.size();

            for (int i = 0; i < count; i++) {
                TreeNode tmpNode = queue.removeFirst();

                if (tmpNode.right != null) {
                    queue.add(tmpNode.right);
                }

                if (tmpNode.left != null) {
                    queue.add(tmpNode.left);
                }
            }
        }

        return resList;

    }
}
