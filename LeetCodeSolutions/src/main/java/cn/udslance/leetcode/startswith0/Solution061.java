package cn.udslance.leetcode.startswith0;

import cn.udslance.beans.ListNode;
import cn.udslance.mytools.Generator;


/**
 * @author H
 * @create 2021-07-14 16:25
 */
public class Solution061 {
    
    public void test() {
        ListNode head = Generator.generateNode(new int[]{1,2});
        ListNode res = rotateRight(head, 1);
        ListNode tmp = res;

        while (tmp != null) {
            System.out.println(tmp);

            tmp = tmp.next;
        }
    }




    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        //获取节点数
        ListNode tmp1 = head;
        int size = 0;
        while (tmp1 != null) {
            size++;
            tmp1 = tmp1.next;
        }

        //(k % size + 1) 表示提取倒数的节点
        int x = size - (k % size + 1);

        tmp1 = head;
        for (int i = 0; i < x; i++) {
            tmp1 = tmp1.next;
        }
        //此时 tmp1 指向结果链表的尾部，他的下一位是结果链表的头部

        ListNode resHead = head;
        if (tmp1.next != null) {
            resHead = tmp1.next;
        } else {
            return resHead;
        }

        ListNode tmp2 = resHead;
        while (tmp2.next != null) {
            tmp2 = tmp2.next;
        }
        //此时 tmp2 指向旋转部分的尾部，将他的 next 连向 head；

        tmp2.next = head;
        tmp1.next = null;
        return resHead;
    }
}
