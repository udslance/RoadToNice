package cn.udslance.leetcode;

import cn.udslance.beans.ListNode;

/**
 * 环形链表 II
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * @author H
 * @create 2021-07-29 9:17
 */
class Solution142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
