package cn.udslance.leetcode.mainofleetcode4;

import cn.udslance.beans.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author H
 * @create 2021-08-23 9:21
 */
public class Solution437 {

    //保存前缀树
    Map<Integer,Integer> mem = new HashMap<Integer,Integer>();

    int target;

    public int pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        //前缀树为0的个数至少是一个
        mem.put(0,1);
        return dfs(root,0);
    }

    public int dfs(TreeNode root,int curSum){
        if(root == null) {
            return 0;
        }
        //得到当前前缀树的值
        curSum += root.val;
        int res = 0;
        //得到我们想要前缀树的个数，想要前缀树值就是当前前缀树值减去目标值
        res = mem.getOrDefault(curSum-target,0);
        //将当前前缀树的值保存
        mem.put(curSum,mem.getOrDefault(curSum,0)+1);
        //遍历左边
        int left = dfs(root.left,curSum);
        //遍历右边
        int right = dfs(root.right,curSum);
        //防止左边前缀树影响右边前缀树，左边前缀树可能有个为6，右边正好想要一个前缀树为6的，这样子就出错了
        mem.put(curSum,mem.get(curSum)-1);
        //结果是当前节点前缀树的个数加上左边满足的个数加右边满足的个数
        return res+left+right;
    }
}
