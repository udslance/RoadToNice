package cn.udslance.leetcode;

import cn.udslance.beans.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author H
 * @create 2021-08-03 20:09
 */
public class BSTIterator {
    private final List<Integer> list = new ArrayList<>();

    public BSTIterator(TreeNode root) {
        mid(root);
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
}
