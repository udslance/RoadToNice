package cn.udslance.leetcode.mainofleetcode2;


import cn.udslance.beans.ListNode;

/**
 * @author H
 * @create 2021-06-10 20:53
 */
public class Solution206 {

    public ListNode reverseList(ListNode head) {
        //特殊情况
        if (head == null || head.next == null) {
            return head;
        }

        //准备辅助链表
        ListNode reverseHead = new ListNode(0);

        //准备辅助指针
        ListNode cur = head;
        ListNode next;

        while (cur != null) {
            next = cur.next;

            cur.next = reverseHead.next;
            reverseHead.next = cur;

            cur = next;
        }

        return reverseHead.next;
    }
}
