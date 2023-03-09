package cn.udslance.leetcode;

import java.util.HashMap;

/**
 * LRU 缓存机制
 * <a href="https://leetcode-cn.com/problems/lru-cache/">link</a>
 * @author H
 * @create 2021-07-29 10:10
 */
class LRUCache {
    private final HashMap<Integer, Node> map;

    private final DoubleList cache;

    private final int cap;

    static class Node {
        public int key, val;
        public Node next, prev;
        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }

    static class DoubleList {
        private Node head;

        private Node tail;

        private int size;

        public void addFirst(Node node) {
            if (head == null) {
                head = tail = node;
            } else {
                Node n = head;
                n.prev = node;
                node.next = n;
                head = node;
            }
            size++;
        }

        public void remove(Node node) {
            if (head == node && tail == node) {
                head = null;
                tail = null;
            } else if (tail == node) {
                node.prev.next = null;
                tail = node.prev;
            } else if (head == node) {
                node.next.prev = null;
                head = node.next;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            size--;
        }

        public Node removeLast() {
            Node node = tail;
            remove(tail);
            return node;
        }

        public int size() {
            return size;
        }
    }

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        int val = map.get(key).val;
        put(key, val);
        return val;
    }

    public void put(int key, int value) {
        Node x = new Node(key, value);
        if (map.containsKey(key)){
            cache.remove(map.get(key));
        } else {
            if (cap == cache.size()) {
                map.remove(cache.removeLast().key);
            }
        }
        cache.addFirst(x);
        map.put(key,x);
    }
}
