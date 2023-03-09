package cn.udslance.leetcode;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: 复制带随机指针的链表
 * @Difficulty: Medium
 * @Link: <a href="https://leetcode.cn/problems/copy-list-with-random-pointer/">link</a>
 * @author H
 *
 */
class Solution138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    static Logger logger = Logger.getLogger("");
    @Test
    public void test() {
        long startTime = System.currentTimeMillis();
        //do something
        long endTime = System.currentTimeMillis();
        logger.info("程序运行时间：" + (endTime - startTime) + " ms");
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> nodeNodeMap = new HashMap<>();
        Node tmp1 = head;
        while (tmp1 != null) {
            nodeNodeMap.put(tmp1, new Node(tmp1.val));
            tmp1 = tmp1.next;
        }
        tmp1 = head;
        while (tmp1 != null) {
            nodeNodeMap.get(tmp1).next = nodeNodeMap.get(tmp1.next);
            nodeNodeMap.get(tmp1).random = nodeNodeMap.get(tmp1.random);
            tmp1 = tmp1.next;
        }

        return nodeNodeMap.get(head);
    }
}
