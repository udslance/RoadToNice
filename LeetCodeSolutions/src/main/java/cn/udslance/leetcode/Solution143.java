package cn.udslance.leetcode;

import cn.udslance.beans.ListNode;

/**
 * @author H
 * @create 2021-07-29 9:59
 */
class Solution143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        int len = 0;
        ListNode h = head;
        //求出节点数
        while (h != null) {
            len++;
            h = h.next;
        }
        reorderListHelper(head, len);
    }

    private ListNode reorderListHelper(ListNode head, int len) {
        if (len == 1) {
            ListNode outTail = head.next;
            head.next = null;
            return outTail;
        }
        if (len == 2) {
            ListNode outTail = head.next.next;
            head.next.next = null;
            return outTail;
        }
        //得到对应的尾节点，并且将头结点和尾节点之间的链表通过递归处理
        ListNode tail = reorderListHelper(head.next, len - 2);
        //中间链表的头结点
        ListNode subHead = head.next;
        head.next = tail;
        //上一层 head 对应的 tail
        ListNode outTail = tail.next;
        tail.next = subHead;
        return outTail;
    }
}
