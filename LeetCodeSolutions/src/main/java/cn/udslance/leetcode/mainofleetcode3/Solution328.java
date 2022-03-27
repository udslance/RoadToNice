package cn.udslance.leetcode.mainofleetcode3;

import cn.udslance.beans.ListNode;

/**
 * @author H
 * @create 2021-08-17 21:15
 */
public class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        //特殊情况
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        //用于标记奇数链尾
        ListNode tmp1 = head;
        //记录偶数头节点，用于拼接
        ListNode concat = head.next;
        //用于标记偶数数链尾
        ListNode tmp2 = head.next;

        //用于遍历
        ListNode cur = tmp2.next;
        tmp2.next = null;

        int i = 0;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = null;
            //判断奇偶
            if (i % 2 == 0) {
                tmp1.next = cur;
                tmp1 = tmp1.next;
            } else {
                tmp2.next = cur;
                tmp2 = tmp2.next;
            }
            ++i;
            cur = next;
        }
        tmp1.next = concat;
        return head;
    }
}
