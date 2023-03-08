package cn.udslance.leetcode;

import cn.udslance.beans.ListNode;

/**
 * @title: K 个一组翻转链表
 * @description: 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * @difficulty: Hard
 * @Link: <a href="https://leetcode.cn/problems/reverse-nodes-in-k-group/description/?orderBy=most_votes">...</a>
 * @author: Udslance
 * @create: 2023-03-05 21:10
 **/
class Solution025 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode next = end.next;
            end.next = null;
            ListNode start = pre.next;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = start;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preNode = null;
        ListNode curNode = head;
        ListNode nextNode = null;
        while (curNode != null) {
            nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        return preNode;
    }
}
