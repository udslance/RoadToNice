package cn.udslance.knowledge.example;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Udslance
 * @create: 2022-10-13 23:10
 **/
class BFSTest {
    /**
     * 从node出发，进行宽度优先遍历
     * @param node
     */
    public static void bfs(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    queue.add(next);
                    set.add(next);
                }
            }
        }
    }
}
