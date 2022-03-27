package cn.udslance.beans;

/**
 * @author H
 * @create 2021-04-27 9:56
 */
public class ListNode {
     public int val;
     public ListNode next;
     public ListNode(int val) { this.val = val; }

     @Override
     public String toString() {
          return "ListNode{" +
                  "val=" + val +
                  '}';
     }
}
