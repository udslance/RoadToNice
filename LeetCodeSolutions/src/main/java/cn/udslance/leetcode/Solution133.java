package cn.udslance.leetcode;

import cn.udslance.beans.NodeB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author H
 * @create 2021-07-26 19:50
 */
class Solution133 {
    public NodeB cloneGraph(NodeB node) {
        // 存放真正“克隆”的 Node（唯一）
        HashMap<Integer, NodeB> helper = new HashMap<>();
        // 第一个数字代表当前节点的val，后面的数字代表他邻居们的val
        List<List<Integer>> list = new ArrayList<>();
        if (node == null) {
            return null;
        }
        //填充helper和list
        cloneGraphHelper(node, helper, list);
        //以list作为依据，从helper中拿取节点，建立邻里关系
        for (List<Integer> integerList : list) {
            NodeB nodeB = helper.get(integerList.get(0));
            for (int i = 1; i < integerList.size(); i++) {
                nodeB.neighbors.add(helper.get(integerList.get(i)));
            }
        }
        return helper.get(node.val);
    }

    /**
     * @param nodeB  当前节点
     * @param helper 存放真正“克隆”的 Node（唯一）
     * @param list   其中，第一个数字代表当前节点的val，后面的数字代表他邻居们的val
     */
    private void cloneGraphHelper(NodeB nodeB, HashMap<Integer, NodeB> helper, List<List<Integer>> list) {
        //终止条件：当前节点已经作为主节点访问过了
        if (helper.containsKey(nodeB.val)) {
            return;
        }
        //存放当前节点，并避免重复递归
        helper.put(nodeB.val, new NodeB(nodeB.val));
        //提取当前节点的邻居们
        List<NodeB> neighbors = nodeB.neighbors;
        List<Integer> integerList = new ArrayList<>();
        integerList.add(nodeB.val);
        for (NodeB neighbor : neighbors) {
            integerList.add(neighbor.val);
            cloneGraphHelper(neighbor, helper, list);
        }
        list.add(integerList);
    }
}
