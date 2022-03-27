package cn.udslance.interview.mi;

/**
 * @author H
 * @create 2021-09-01 19:49
 */
public class Mi004 {
    public static void main(String[] args) {
        solution4(5);
    }

    public static void solution4(int n) {
        //需要先构建一个环形链表
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i <= n; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }

        cur.next = head;
        //环形链表构建完成
        //最后 cur 指向结尾
        while (cur.next != cur) {
            cur = cur.next.next;
            head = head.next.next;
            cur.next = head.next;
            head = head.next;
        }
        //链表只剩下了cur
        System.out.println(cur.val);
    }


    static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) { val = x; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }
}
