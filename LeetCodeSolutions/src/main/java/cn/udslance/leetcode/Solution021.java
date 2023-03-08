package cn.udslance.leetcode;

import cn.udslance.beans.ListNode;
import cn.udslance.mytools.LeetCodeUtils;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

/**
 * @author H
 * @Title: 合并两个有序链表
 * @Difficulty: easy
 * @Link: <a href="https://leetcode.cn/problems/merge-two-sorted-lists/">...</a>
 */
class Solution021 {
    static Logger logger = Logger.getLogger("");

    @Test
    public void test() {
        long startTime = System.currentTimeMillis();
        //do something
        ListNode list1 = LeetCodeUtils.makeListNodeByArr(new int[]{2});
        ListNode list2 = LeetCodeUtils.makeListNodeByArr(new int[]{1});
        ListNode res = mergeTwoLists(list1, list2);
        while (res != null) {
            System.out.println(res);
            res = res.next;
        }
        long endTime = System.currentTimeMillis();
        logger.info("程序运行时间：" + (endTime - startTime) + " ms");
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 特殊情况
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode head = list1.val <= list2.val ? list1 : list2;
        ListNode tmp1 = list1.val <= list2.val ? list1.next : list1;
        ListNode tmp2 = list2.val < list1.val ? list2.next : list2;
        ListNode tmpH = head;
        while (tmp1 != null || tmp2 != null) {
            if (tmp1 == null) {
                tmpH.next = new ListNode(tmp2.val);
                tmp2 = tmp2.next;
            } else if (tmp2 == null) {
                tmpH.next = new ListNode(tmp1.val);
                tmp1 = tmp1.next;
            } else if (tmp1.val > tmp2.val) {
                tmpH.next = new ListNode(tmp2.val);
                tmp2 = tmp2.next;
            } else {
                tmpH.next = new ListNode(tmp1.val);
                tmp1 = tmp1.next;

            }
            tmpH = tmpH.next;
        }

        return head;
    }
}
