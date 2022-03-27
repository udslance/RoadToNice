package cn.udslance.leetcode.mainofleetcode0;

import cn.udslance.beans.ListNode;
import cn.udslance.mytools.Generator;


/**
 * @author H
 * @create 2021-06-26 23:11
 */
public class Solution024 {


    public void test1() {
        ListNode listNode = Generator.generateNode(new int[]{1,2,3,4,5,6});

        ListNode listNode1 = swapPairs(listNode);

        ListNode tmp = listNode1;

        while (tmp != null) {

            System.out.println(tmp);

            tmp = tmp.next;
        }
    }


    public ListNode swapPairs(ListNode head) {
        //提供一个头节点
        ListNode swapHead = new ListNode(0);

        swapHead.next = head;

        ListNode temp1 = swapHead;

        ListNode help;

        while (temp1.next != null && temp1.next.next != null) {
            ListNode temp2 = temp1.next;

            temp1.next = temp2.next;

            temp1 = temp1.next;

            help = temp1.next;

            temp1.next = temp2;

            temp2.next = help;

            temp1 = temp1.next;


        }

        return swapHead.next;
    }
}
