package cn.udslance.leetcode.mainofleetcode2;

import cn.udslance.beans.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author H
 * @create 2021-08-23 9:21
 */
public class Solution230 {

    public void test() {

    }

    int size = 0;



    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        size = k;
        inOrder(root, list);

        return list.get(k - 1);
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null || list.size() == size) {
            return;
        }

        inOrder(root.left, list);

        list.add(root.val);

        inOrder(root.right, list);
    }
}
