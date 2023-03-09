package cn.udslance.leetcode;

import cn.udslance.beans.ListNode;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

/**
 * @Title: 相交链表
 * @Difficulty: Easy
 * @Link: <a href="https://leetcode.cn/problems/intersection-of-two-linked-lists/">link</a>
 * @author H
 *
 */
class Solution160 {
    static Logger logger = Logger.getLogger("");
    @Test
    public void test() {
        long startTime = System.currentTimeMillis();
        //do something
        long endTime = System.currentTimeMillis();
        logger.info("程序运行时间：" + (endTime - startTime) + " ms");
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lengthA = 1;
        int lengthB = 1;
        ListNode tmpA = headA;
        ListNode tmpB = headB;
        while (tmpA.next != null) {
            lengthA++;
            tmpA = tmpA.next;
        }
        while (tmpB.next != null) {
            lengthB++;
            tmpB = tmpB.next;
        }
        if (tmpB != tmpA) {
            return null;
        }
        ListNode fast = lengthA > lengthB ? headA : headB;
        ListNode slow = lengthA > lengthB ? headB : headA;
        int step = Math.abs(lengthA - lengthB);
        for (int i = 0; i < step; i++) {
            fast = fast.next;
        }
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
