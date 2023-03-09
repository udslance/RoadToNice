package cn.udslance.leetcode;

/**
 * @title: H 指数 II
 * @description:
 * @difficulty: Medium
 * @Link: <a href="https://leetcode.cn/problems/h-index-ii/description/?orderBy=most_votes">link</a>
 * @author: Udslance
 * @create: 2023-02-19 16:07
 **/
class Solution275 {
    public int hIndex(int[] citations) {
        int left = 0;
        int right = citations.length - 1;
        int nums = citations.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums - mid <= citations[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
