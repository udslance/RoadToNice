package cn.udslance.leetcode.startswith1;

import cn.udslance.beans.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author H
 * @create 2021-07-22 19:03
 */
public class Solution103 {

    
    public void test() {
        TreeNode t3 = new TreeNode(3);
        TreeNode t9 = new TreeNode(9);
        TreeNode t20 = new TreeNode(20);
        TreeNode t15 = new TreeNode(15);
        TreeNode t7 = new TreeNode(7);
        TreeNode t21 = new TreeNode(21);
        TreeNode t22 = new TreeNode(22);

        t3.left = t9;
        t3.right = t20;

        t20.left = t15;
        t20.right = t7;

        t9.left = t21;
        t9.right = t22;



        List<List<Integer>> res = zigzagLevelOrder(t3);

        for (List<Integer> integerList : res) {
            System.out.println(integerList);
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        Queue<TreeNode> treeNodes = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        if (root != null) {
            treeNodes.add(root);
        }

        while (treeNodes.size() != 0) {
            LinkedList<Integer> list = new LinkedList<>();
            int count = treeNodes.size();

            for (int i = 0; i < count; i++) {
                TreeNode temp = treeNodes.poll();

                //将值添加到list中
                if (res.size() % 2 == 0) {
                    list.addLast(temp.val);
                } else {
                    assert temp != null;
                    list.addFirst(temp.val);
                }

                if (temp.left != null) {
                    treeNodes.add(temp.left);
                }

                if (temp.right != null) {
                    treeNodes.add(temp.right);
                }
                
            }


            res.add(list);
            
        }

        return res;
    }
}
