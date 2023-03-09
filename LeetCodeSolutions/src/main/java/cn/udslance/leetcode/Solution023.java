package cn.udslance.leetcode;

import cn.udslance.beans.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @title: 合并K个升序链表
 * @description: 给你一个链表数组，每个链表都已经按升序排列。
 * @difficulty: Hard
 * @Link: <a href="https://leetcode.cn/problems/merge-k-sorted-lists/">link</a>
 * @author: Udslance
 * @create: 2023-03-05 20:40
 **/
class Solution023 {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> allNums = new ArrayList<>();
        for (ListNode tempHead : lists) {
            while (tempHead != null) {
                allNums.add(tempHead.val);
                tempHead = tempHead.next;
            }
        }
        if (allNums.isEmpty()) {
            return null;
        }
        Collections.sort(allNums);
        ListNode resHead = new ListNode(allNums.get(0));
        ListNode poke = resHead;
        for (int i = 1; i < allNums.size(); i++) {
            poke.next = new ListNode(allNums.get(i));
            poke = poke.next;
        }
        return resHead;
    }
}
