package cn.udslance.leetcode;

import cn.udslance.beans.ListNode;

/**
 * @author H
 * @create 2021-06-26 23:11
 */
class Solution024 {


    public ListNode swapPairs(ListNode head) {
        //提供一个头节点
        ListNode swapHead = new ListNode(0);
        swapHead.next = head;
        ListNode temp1 = swapHead;
        ListNode help;
        while (temp1.next != null && temp1.next.next != null) {
            ListNode temp2 = temp1.next;
            temp1.next = temp2.next;
            temp1 = temp1.next;
            help = temp1.next;
            temp1.next = temp2;
            temp2.next = help;
            temp1 = temp1.next;
        }
        return swapHead.next;
    }
}
