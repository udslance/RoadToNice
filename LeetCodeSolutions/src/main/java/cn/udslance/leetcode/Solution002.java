package cn.udslance.leetcode;
import cn.udslance.beans.ListNode;
import cn.udslance.mytools.LeetCodeUtils;
import org.junit.jupiter.api.Test;

/**
 * 两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/
 * @author H
 * @create 2021-08-23 9:21
 */
class Solution002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 结果链表
        ListNode head = new ListNode(0);
        ListNode th = head;
        // 两个指针同时遍历两个链表
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        int val1 = 0;
        int val2 = 0;
        int val3 = 0;
        int ten = 0;
        while (tmp1 != null || tmp2 != null) {
            val1 = tmp1 == null ? 0 : tmp1.val;
            val2 = tmp2 == null ? 0 : tmp2.val;
            val3 = (val1 + val2 + ten) % 10;
            ten = (val1 + val2 + ten) / 10;
            // 在head后面接上
            th.next = new ListNode(val3);
            th = th.next;
            if (tmp1 != null) {
                tmp1 = tmp1.next;
            }
            if (tmp2 != null) {
                tmp2 = tmp2.next;
            }
        }

        if (ten == 1) {
            th.next = new ListNode(1);
        }
        return head.next;
    }
    @Test
    public void test() {
        ListNode lA = LeetCodeUtils.makeListNodeByArr(new int[]{2,4,3});
        ListNode lB = LeetCodeUtils.makeListNodeByArr(new int[]{5,6,4});
        long startTime = System.currentTimeMillis();
        //do something
        addTwoNumbers(lA, lB);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
}
