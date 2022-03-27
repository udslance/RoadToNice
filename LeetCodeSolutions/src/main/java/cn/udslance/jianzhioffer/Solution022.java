package cn.udslance.jianzhioffer;

import cn.udslance.beans.ListNode;

/**
 * @author H
 * @create 2021-08-23 9:21
 */
public class Solution022 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
