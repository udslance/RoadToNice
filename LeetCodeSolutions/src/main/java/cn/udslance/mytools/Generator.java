package cn.udslance.mytools;

import cn.udslance.beans.ListNode;

/**
 * @author H
 * @create 2021-06-17 23:18
 */
public class Generator {

    public static ListNode generateNode(int[] ints) {
        ListNode head = new ListNode(ints[0]);

        ListNode cur = head;

        for (int i = 1; i < ints.length; i++) {
            cur.next = new ListNode(ints[i]);

            cur = cur.next;
        }

        return head;

    }
}
