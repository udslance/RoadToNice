package cn.udslance.leetcode.startswith0;

import cn.udslance.beans.ListNode;
import cn.udslance.mytools.Generator;


/**
 * @author H
 * @create 2021-07-17 15:51
 */
public class Solution086 {

    
    public void test() {
        ListNode head = Generator.generateNode(new int[]{2,1});

        ListNode res = partition(head,2);

        while (res != null) {
            System.out.println(res);
            res = res.next;
        }
    }


    public ListNode partition(ListNode head, int x) {
        //特殊情况
        if (head == null || head.next == null) {
            return head;
        }

        //辅助头节点
        ListNode resHead = new ListNode(0);
        resHead.next = head;

        //插入点
        ListNode tmpA = resHead;
        //遍历点
        ListNode tmpB = resHead;

        while (tmpB.next != null) {
            if (tmpB.next.val < x && tmpB != tmpA) {
                //如果遍历点的下一位小于目标值，则将其取出，并插入到插入点的后方

                //将遍历点的下一位取出
                ListNode tmpC = tmpB.next;
                tmpB.next = tmpC.next;

                //插入到插入点的后方
                tmpC.next = tmpA.next;
                tmpA.next = tmpC;

                //插入点后移
                tmpA = tmpA.next;
            } else if (tmpB.next.val < x) {
                //如果插入点和遍历点在同一个位置，就没有必要进行取出和插入操作
                //后移即可
                tmpB = tmpB.next;
                //为保证两个分区中每个节点的初始相对位置，插入点也要后移
                tmpA = tmpA.next;
            } else {
                //如果不小于目标值，则仅将遍历点后移
                tmpB = tmpB.next;
            }
        }
        return resHead.next;
    }
}
