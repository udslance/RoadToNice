package cn.udslance.leetcode;

/**
 * 实现 Trie (前缀树)
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 * @author H
 * @create 2021-08-09 18:58
 */
class Trie {

    /**
     * 定义类 Trie
     */
    static class TireNode {
        private boolean isEnd;
        TireNode[] next;

        public TireNode() {
            isEnd = false;
            next = new TireNode[26];
        }
    }

    private final TireNode root;

    public Trie() {
        root = new TireNode();
    }

    /**
     * 向 Trie 中插入一个单词 word
     * 这个操作和构建链表很像。首先从根结点的子结点开始与 word 第一个字符进行匹配，
     * 一直匹配到前缀链上没有对应的字符，这时开始不断开辟新的结点，直到插入完 word
     * 的最后一个字符，同时还要将最后一个结点isEnd = true;，表示它是一个单词的末尾。
     * @param word ...
     */
    public void insert(String word) {
        TireNode node = root;
        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new TireNode();
            }
            node = node.next[c - 'a'];
        }
        node.isEnd = true;
    }

    /**
     * 查找 Trie 中是否存在单词 word
     * 从根结点的子结点开始，一直向下匹配即可，如果出现结点值为空就返回 false，如果匹
     * 配到了最后一个字符，那我们只需判断 node->isEnd即可。
     * @param word ...
     * @return ...
     */
    public boolean search(String word) {
        TireNode node = root;
        for (char c : word.toCharArray()) {
            node = node.next[c - 'a'];
            if (node == null) {
                return false;
            }
        }
        return node.isEnd;
    }

    /**
     * 判断 Trie 中是或有以 prefix 为前缀的单词
     * 和 search 操作类似，只是不需要判断最后一个字符结点的isEnd，因为既然能匹配到
     * 最后一个字符，那后面一定有单词是以它为前缀的。
     * @param prefix ...
     * @return ...
     */
    public boolean startsWith(String prefix) {
        TireNode node = root;
        for (char c : prefix.toCharArray()) {
            node = node.next[c - 'a'];
            if (node == null) {
                return false;
            }
        }
        return true;
    }
}
