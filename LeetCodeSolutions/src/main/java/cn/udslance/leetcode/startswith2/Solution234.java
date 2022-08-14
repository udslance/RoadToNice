package cn.udslance.leetcode.startswith2;

import cn.udslance.beans.ListNode;
import cn.udslance.mytools.Generator;

/**
 * @author H
 * @create 2021-06-12 8:17
 */
class Solution234 {
    public static void main(String[] args) {
        Solution234 solution234 = new Solution234();

        int[] ints = {1,0,0};

        ListNode listNode = Generator.generateNode(ints);

        System.out.println(solution234.isPalindrome(listNode));

    }

    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }

        ListNode orgHead = new ListNode(head.val);

        ListNode temp = head.next;

        while (temp != null) {
            orgHead.next = new ListNode(temp.val);

            temp = temp.next;

            orgHead = orgHead.next;
        }


        ListNode reverseHead = reverseList(head);


        return reverseHead.equals(orgHead);

    }

    public ListNode reverseList(ListNode head) {
        //特殊情况
        if (head == null || head.next == null) {
            return head;
        }

        //准备辅助链表
        ListNode reverseHead = new ListNode(0);

        //准备辅助指针
        ListNode cur = head;
        ListNode next;

        //正式反转
        while (cur != null) {
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        return reverseHead.next;
    }
}
