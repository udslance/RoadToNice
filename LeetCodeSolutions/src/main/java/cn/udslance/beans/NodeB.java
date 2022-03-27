package cn.udslance.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author H
 * @create 2021-07-26 19:49
 */
public class NodeB {
    public int val;
    public List<NodeB> neighbors;
    public NodeB() {
        val = 0;
        neighbors = new ArrayList<NodeB>();
    }
    public NodeB(int _val) {
        val = _val;
        neighbors = new ArrayList<NodeB>();
    }
    public NodeB(int _val, ArrayList<NodeB> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
