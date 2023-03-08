package cn.udslance.leetcode;

import cn.udslance.beans.ListNode;
import cn.udslance.mytools.LeetCodeUtils;

/**
 * @author H
 * @create 2021-06-12 8:17
 */
class Solution234 {
    public static void main(String[] args) {
        Solution234 solution234 = new Solution234();
        int[] ints = {1,2,2,1};
        ListNode listNode = LeetCodeUtils.makeListNodeByArr(ints);
        System.out.println(solution234.isPalindrome(listNode));
    }

    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }
        ListNode orgTmp = new ListNode(head.val);
        ListNode orgHead = orgTmp;
        ListNode temp = head.next;
        while (temp != null) {
            orgTmp.next = new ListNode(temp.val);
            temp = temp.next;
            orgTmp = orgTmp.next;
        }
        ListNode reverseHead = reverseList(head);
        return isSame(reverseHead, orgHead);
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

    private boolean isSame(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1 == null && l2 == null;
    }
}
