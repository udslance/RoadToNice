package cn.udslance.knowledge.example;

import java.util.ArrayList;

/**
 * @author: Udslance
 * @create: 2022-10-13 23:06
 **/
class Node {
    public int value;
    public int in;
    public int out;
    public ArrayList<Node> nexts;
    public ArrayList<Edge> edges;

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
