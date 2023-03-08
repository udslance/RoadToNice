package cn.udslance.leetcode;

import cn.udslance.beans.TreeNode;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的右视图
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 * @author H
 * @create 2021-08-08 22:38
 */
class Solution199 {
    Logger logger = Logger.getLogger("");

    @Test
    public void testUrAnswer() {
        long startTime = System.currentTimeMillis();

        LocalDateTime res = stringToLocalDateTime("2022-12-02 22:00:00", "yyyy-MM-dd HH:mm:ss");
        System.out.println(res);
    }




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

    public LocalDateTime stringToLocalDateTime(String str, String format) {
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
            return LocalDateTime.parse(str, dateTimeFormatter);
        } catch (DateTimeParseException e) {
            logger.warn("DateTimeParseException");
        }
        return null;
    }

    private DateTimeFormatter getDateTimeFormatter(String format) {
        return null;
    }
}
