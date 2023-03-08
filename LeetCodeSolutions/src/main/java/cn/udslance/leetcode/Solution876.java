package cn.udslance.leetcode;

import cn.udslance.beans.ListNode;

/**
 * @title: 链表的中间结点
 * @description: Easy
 * @difficulty: 给你单链表的头结点 head ，请你找出并返回链表的中间结点。
 * @Link: <a href="https://leetcode.cn/problems/middle-of-the-linked-list/">...</a>
 * @author: Udslance
 * @create: 2023-03-05 21:45
 **/
class Solution876 {
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null) {
            for (int i = 0; i < 2 && fast.next != null; i++) {
                fast = fast.next;
            }
            slow = slow.next;
        }
        return slow;
    }
}
