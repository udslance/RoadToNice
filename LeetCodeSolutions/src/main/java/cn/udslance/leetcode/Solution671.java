package cn.udslance.leetcode;

import cn.udslance.beans.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author H
 * @create 2021-07-27 22:54
 */
class Solution671 {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return -1;
        }

        List<TreeNode> queue = new ArrayList<>();

        queue.add(root);
        int res = -1;
        int top2 = root.val;

        while (!queue.isEmpty()) {
            int count = queue.size();
            boolean flag = false;

            for (int i = 0; i < count; i++) {
                TreeNode tmp = queue.remove(0);
                if (tmp.val > top2) {
                    top2 = tmp.val;
                }

                if (tmp.left != null) {
                    queue.add(tmp.left);
                    queue.add(tmp.right);
                }
            }
        }

        return res;
    }
}
