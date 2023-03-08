package cn.udslance.leetcode;

import cn.udslance.beans.ListNode;
import cn.udslance.mytools.LeetCodeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 删除链表的倒数第 N 个结点
 * @author H
 * @create 2021-06-18 23:32
 */
class Solution019 {
    
    public void test() {
        int[] ints = new int[]{1};

        ListNode listNode = LeetCodeUtils.makeListNodeByArr(ints);

        removeNthFromEnd(listNode, 1);

    }

    /**
     * 快慢指针
     * @param head 链表头节点
     * @param n 倒数第几个
     * @return
     *
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        // 全部放入List当中
        List<ListNode> nodeList = new ArrayList<>();
        ListNode tmp1 = head;
        // 只进行一次遍历
        while (tmp1 != null) {
            nodeList.add(tmp1);
            tmp1 = tmp1.next;
        }
        // 获取链表的长度
        int size = nodeList.size();
        int pre = size - n - 1;
        int aft = size - n + 1;
        // 特殊情况1：倒数第一个
        if (aft >= size) {
            nodeList.get(pre).next = null;
        }
        // 特殊情况2：正数第一个
        else if (pre < 0) {
            return head.next;
        }
        //普通情况
        else {
            nodeList.get(pre).next = nodeList.get(aft);
        }

        return head;
    }

}
