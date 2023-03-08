package cn.udslance.leetcode;

import cn.udslance.beans.TreeNode;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author H
 * @create 2021-07-21 20:37
 */
class Solution098 {
    private static final Logger LOGGER = Logger.getLogger("");

    @Test
    public void testUrAnswer() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        t5.left = t1;
        t5.right = t4;
        t4.left = t3;
        t4.right = t6;
        long startTime = System.currentTimeMillis();
        // do something!
        String res = isValidBST(t5) + "";
        LOGGER.error("运行结果：" + res);
        // end
        long endTime = System.currentTimeMillis();
        LOGGER.info("程序运行时间：" + (endTime - startTime) + " ms");
    }



    public boolean isValidBST(TreeNode root) {
        List<Integer> inOrderList = new ArrayList<>();
        helper(root, inOrderList);
        for (int i = 0; i < inOrderList.size() - 1; i++) {
            if (inOrderList.get(i) >= inOrderList.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private void helper(TreeNode root, List<Integer> inOrderList) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            helper(root.left, inOrderList);
        }
        inOrderList.add(root.val);
        if (root.right != null) {
            helper(root.right, inOrderList);
        }
    }
}
