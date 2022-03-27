package cn.udslance.leetcode.mainofleetcode1;

import cn.udslance.beans.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author H
 * @create 2021-07-22 20:47
 */
public class Solution107 {
    
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



        List<List<Integer>> res = levelOrderBottom(t3);

        for (List<Integer> integerList : res) {
            System.out.println(integerList);
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();

        if (root != null) {
            treeNodeQueue.add(root);
        }

        while (treeNodeQueue.size() != 0) {
            List<Integer> list = new ArrayList<>();
            int count = treeNodeQueue.size();

            for (int i = 0; i < count; i++) {
                TreeNode temp = treeNodeQueue.poll();

                list.add(temp.val);

                if (temp.left != null) {
                    treeNodeQueue.add(temp.left);
                }

                if (temp.right != null) {
                    treeNodeQueue.add(temp.right);
                }
                
            }

            res.addFirst(list);
        }
        

        return res;
    }
}
