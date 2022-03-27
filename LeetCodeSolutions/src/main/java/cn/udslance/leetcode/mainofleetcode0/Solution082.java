package cn.udslance.leetcode.mainofleetcode0;

import cn.udslance.beans.ListNode;
import cn.udslance.mytools.Generator;


/**
 * @author H
 * @create 2021-07-17 14:50
 */
public class Solution082 {
    
    public void test() {
        ListNode head = Generator.generateNode(new int[]{1,1,1,2,3});

        ListNode res = deleteDuplicates(head);

        while (res != null) {
            System.out.println(res);
            res = res.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        //特殊情况
        if (head == null || head.next == null) {
            return head;
        }

        //辅助头节点
        ListNode resHead = new ListNode(0);
        resHead.next = head;

        ListNode tmpA = resHead;
        ListNode tmpB = resHead.next;

        while (tmpB != null) {
            //检测是否重复
            if (tmpB.next != null && tmpB.val == tmpB.next.val) {
                //若出现重复，B指针应移动到最后一个重复节点的下一位
                while (tmpB.next != null && tmpB.val == tmpB.next.val) {
                    tmpB = tmpB.next;
                }
                tmpB = tmpB.next;

                //删除重复节点
                tmpA.next = tmpB;
            }else {
                //若没有出现重复，则正常后移
                tmpA = tmpB;
                tmpB = tmpB.next;
            }
        }

        return resHead.next;
    }
}
