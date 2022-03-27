package cn.udslance.leetcode.mainofleetcode0;

import cn.udslance.beans.ListNode;
import cn.udslance.mytools.Generator;


/**
 * 删除链表的倒数第 N 个结点
 * @author H
 * @create 2021-06-18 23:32
 */
public class Solution019 {
    
    public void test() {
        int[] ints = new int[]{1};

        ListNode listNode = Generator.generateNode(ints);

        removeNthFromEnd(listNode, 1);

    }

    /**
     * 快慢指针
     * @param head 链表头节点
     * @param n 倒数第几个
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        ListNode fast = head;

        //count 记录慢指针遍历了多少个节点
        int count = 1;

        while (fast.next != null) {
            fast = fast.next;
            ++count;
        }

        //index 标记删除点
        int index = count - n;

        fast = head;

        for (int i = 1; i < index - 1; i++) {
            fast = fast.next;
        }

        ListNode tmp = fast.next.next;

        fast.next = tmp;


        return head;
    }
}
