package cn.udslance.leetcode.startswith1;

import cn.udslance.beans.ListNode;

/**
 * 对链表进行插入排序
 * https://leetcode-cn.com/problems/insertion-sort-list/
 * @author H
 * @create 2021-07-29 11:25
 */
public class Solution147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode lastSorted = dummyHead.next;
        ListNode wait = head.next;

        while (wait != null) {
            if (lastSorted.val <= wait.val) {
                lastSorted = lastSorted.next;

            } else {
                ListNode temp = dummyHead;
                while (wait.val > temp.next.val) {
                    temp = temp.next;
                }

                lastSorted.next = wait.next;

                wait.next = temp.next;
                temp.next = wait;

            }
            wait = lastSorted.next;
        }

        return dummyHead.next;
    }
}
