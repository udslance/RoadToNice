package cn.udslance.leetcode;

import cn.udslance.beans.ListNode;
import cn.udslance.mytools.LeetCodeUtils;
import org.junit.jupiter.api.Test;

/**
 * @title: 移除链表元素
 * @description: 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * @difficulty: Easy
 * @Link: <a href="https://leetcode.cn/problems/remove-linked-list-elements/">link</a>
 * @author: Udslance
 * @create: 2023-03-08 21:49
 **/
class Solution203 {
    @Test
    public void test() {
        ListNode listNode = LeetCodeUtils.makeListNodeByArr(new int[]{1, 2, 6, 3, 4, 5, 6});
        removeElements(listNode, 6);
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode tmp = dummyHead;
        while (tmp.next != null) {
            while (tmp.next != null && tmp.next.val == val) {
                tmp.next = tmp.next.next;
            }
            if (tmp.next == null) {
                break;
            }
            tmp = tmp.next;
        }
        return dummyHead.next;
    }
}
