package cn.udslance.leetcode;

import cn.udslance.beans.ListNode;

/**
 * @title: 删除链表中的节点
 * @description: 有一个单链表的 head，我们想删除它其中的一个节点 node。
 * @difficulty: Medium
 * @Link: <a href="https://leetcode.cn/problems/delete-node-in-a-linked-list/description/">link</a>
 * @author: Udslance
 * @create: 2023-02-19 11:20
 **/
class Solution237 {
    public void deleteNode(ListNode node) {
        // 将自己与子节点交换，然后删掉子节点
        ListNode childNode = node.next;
        int tempVal = node.val;
        node.val = childNode.val;
        childNode.val = tempVal;
        node.next = node.next.next;
    }
}
