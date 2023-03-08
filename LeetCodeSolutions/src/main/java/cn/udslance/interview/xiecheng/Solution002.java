package cn.udslance.interview.xiecheng;

import cn.udslance.beans.TreeNode;

/**
 * @author H
 * @create 2021-08-23 9:21
 */
class Solution002 {
    
    public void test() {
        long startTime = System.currentTimeMillis();
        //do something
        //初始化树
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);

        root1.left = root2;
        root2.left = root4;
        root4.left = root5;

        root1.right = root3;

        //测试
        System.out.println(search(root1));

        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }


    //返回一颗二叉树的高度
    public int search(TreeNode root){
        //if(root == null){
        //    return 0;
        //}

        return height(root);
    }

    public int height(TreeNode root){
        if (root == null) {
            return 0;
        }

        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
