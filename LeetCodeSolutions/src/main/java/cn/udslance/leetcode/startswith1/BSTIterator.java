package cn.udslance.leetcode.startswith1;

import cn.udslance.beans.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author H
 * @create 2021-08-03 20:09
 */
public class BSTIterator {
    private List<Integer> list = new ArrayList<>();

    public BSTIterator(TreeNode root) {
        mid(root);
    }

    private void mid(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            mid(root.left);
        }

        list.add(root.val);

        if (root.right != null) {
            mid(root.right);
        }
    }

    public int next() {
        if (hasNext()) {
            return list.remove(0);
        } else {
            return -1;
        }
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }
}
