package cn.udslance.leetcode.startswith0;

import cn.udslance.beans.ListNode;
import cn.udslance.mytools.Generator;


/**
 * @author H
 * @create 2021-07-17 21:51
 */
public class Solution092 {
    
    public void test() {
        ListNode head = Generator.generateNode(new int[]{1,2});
        ListNode res = reverseBetween(head, 2, 2);
        while (res != null) {
            System.out.println(res);
            res = res.next;
        }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        //特殊情况
        if (head == null || head.next == null || left == right) {
            return head;
        }
        //辅助头节点
        ListNode resHead = new ListNode(-1);
        //双指针
        ListNode tmpA = resHead;
        ListNode tmpB = head;
        ListNode next;
        //寻找 left 位置
        for (int i = 0; i < left - 1; i++) {
            next = tmpB.next;
            tmpB.next = null;
            tmpA.next = tmpB;
            tmpA = tmpA.next;
            tmpB = next;
        }
        //存下未来旋转后的左端，方便连接
        ListNode tmpC = tmpB;
        //tmpB 已定位 left 开始用头插法旋转
        for (int i = 0; i < right - left + 1; i++) {
            next = tmpB.next;
            tmpB.next = tmpA.next;
            tmpA.next = tmpB;
            tmpB = next;
        }
        //连接尾部不需要旋转的部分
        tmpC.next = tmpB;
        return resHead.next;
    }
}
