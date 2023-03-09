package cn.udslance.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @title: 两个数组的交集
 * @description: 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 * @difficulty: Hard
 * @Link: <a href="https://leetcode.cn/problems/intersection-of-two-arrays/">link</a>
 * @author: Udslance
 * @create: 2023-03-09 23:01
 **/
class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums2) {
            set2.add(i);
        }
        List<Integer> resList = new ArrayList<>();
        if (set1.size() >= set2.size()) {
            for (Integer integer : set1) {
                if (set2.contains(integer)) {
                    resList.add(integer);
                }
            }
        } else {
            for (Integer integer : set2) {
                if (set1.contains(integer)) {
                    resList.add(integer);
                }
            }
        }

        int[] resArr = new int[resList.size()];

        for (int i = 0; i < resArr.length; i++) {
            resArr[i] = resList.get(i);
        }

        return resArr;
    }
}
