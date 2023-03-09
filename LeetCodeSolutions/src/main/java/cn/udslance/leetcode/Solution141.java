package cn.udslance.leetcode;

import cn.udslance.beans.ListNode;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

/**
 * @Title: 环形链表
 * @Difficulty: Easy
 * @Link: <a href="https://leetcode.cn/problems/linked-list-cycle/">link</a>
 * @author H
 *
 */
class Solution141 {
    static Logger logger = Logger.getLogger("");
    @Test
    public void test() {
        long startTime = System.currentTimeMillis();
        //do something
        long endTime = System.currentTimeMillis();
        logger.info("程序运行时间：" + (endTime - startTime) + " ms");
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast.next != null) {
            if (fast == slow) {
                return true;
            }
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
            } else {
                return false;
            }
            slow = slow.next;
        }
        return false;
    }
}
