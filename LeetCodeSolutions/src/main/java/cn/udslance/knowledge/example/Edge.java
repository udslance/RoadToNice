package cn.udslance.knowledge.example;

/**
 * @author: Udslance
 * @create: 2022-10-13 23:06
 **/
class Edge {
    public int weight;
    public Node from;
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
