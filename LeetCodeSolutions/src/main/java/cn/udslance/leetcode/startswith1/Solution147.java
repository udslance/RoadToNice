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
        // 首先判断给定的链表是否为空，若为空，则不需要进行排序，直接返回。
        if (head == null || head.next == null) {
            return head;
        }
        // 创建哑节点 dummyHead，令 dummyHead.next = head。引入哑节点是为了便于在 head 节点之前插入节点。
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        // 维护 lastSorted 为链表的已排序部分的最后一个节点，初始时 lastSorted = head。
        ListNode lastSorted = dummyHead.next;
        // 维护 curr 为待插入的元素，初始时 curr = head.next。
        ListNode curr = head.next;
        while (curr != null) {
            /*
             * 比较 lastSorted 和 curr 的节点值。
             * 若 lastSorted.val <= curr.val，
             * 说明 curr 应该位于 lastSorted 之后，
             * 将 lastSorted 后移一位，curr 变成新的 lastSorted。
             * 否则，从链表的头节点开始往后遍历链表中的节点，
             * 寻找插入 curr 的位置。令 prev 为插入 curr 的位置的前一个节点，完成对 curr 的插入：
             */
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode temp = dummyHead;
                while (curr.val > temp.next.val) {
                    temp = temp.next;
                }
                lastSorted.next = curr.next;
                curr.next = temp.next;
                temp.next = curr;

            }
            curr = lastSorted.next;
        }
        return dummyHead.next;
    }
}
