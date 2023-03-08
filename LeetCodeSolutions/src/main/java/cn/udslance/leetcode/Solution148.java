package cn.udslance.leetcode;

import cn.udslance.beans.ListNode;

/**
 * @author H
 * @create 2021-08-01 19:05
 */
class Solution148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //利用快慢指针对半拆分链表
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        //递归拆分
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;

        //组合
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        //最后接上剩下的那个
        h.next = left != null ? left : right;
        return res.next;
    }
}
