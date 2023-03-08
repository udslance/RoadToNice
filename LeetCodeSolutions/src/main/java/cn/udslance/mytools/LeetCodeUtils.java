package cn.udslance.mytools;

import cn.udslance.beans.ListNode;
import cn.udslance.beans.TreeNode;
import org.apache.log4j.Logger;

/**
 * @author H
 * @create 2021-06-17 23:18
 */
public class LeetCodeUtils {

    private static final Logger LOG = Logger.getLogger("LeetCodeUtils");

    private LeetCodeUtils() {
        
    }
    
    /**
     * 将数组转换成链表
     * @param arr 原始数组
     * @return 链表头节点
     */
    public static ListNode makeListNodeByArr(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }

    /**
     * 打印一条链表
     * @param head 链表头节点
     */
    public static void printListNode(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode cursor = head;
        StringBuilder sb = new StringBuilder("head: " + head.val);
        cursor = cursor.next;
        while (cursor != null) {
            sb.append(" --> ").append(cursor.val);
            cursor = cursor.next;
        }
        LOG.info(sb);
    }

    /**
     * 打印一棵二叉树
     * @param head 二叉树头节点
     */
    public static void printTree(TreeNode head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    private static void printInOrder(TreeNode head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.val + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    private static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }
}
