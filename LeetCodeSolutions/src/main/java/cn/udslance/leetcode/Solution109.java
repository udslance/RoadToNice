package cn.udslance.leetcode;

import cn.udslance.beans.ListNode;
import cn.udslance.beans.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @title: 有序链表转换二叉搜索树
 * @description: 给定一个单链表的头节点  head ，其中的元素 按升序排序 ，将其转换为高度平衡的二叉搜索树。
 * @difficulty: Medium
 * @Link: <a href="https://leetcode.cn/problems/convert-sorted-list-to-binary-search-tree/">...</a>
 * @author: Udslance
 * @create: 2022-09-25 23:27
 **/
class Solution109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        List<Integer> nums = new ArrayList<>();
        ListNode tmp = head;
        while (tmp != null) {
            nums.add(tmp.val);
            tmp = tmp.next;
        }
        return sortedArrayToBST(nums);
    }

    private TreeNode sortedArrayToBST(List<Integer> nums) {
        return help(nums, 0, nums.size() - 1);
    }

    private TreeNode help(List<Integer> nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode midNode = new TreeNode(nums.get(mid));
        midNode.left = help(nums, start, mid - 1);
        midNode.right = help(nums, mid + 1, end);
        return midNode;
    }
}
