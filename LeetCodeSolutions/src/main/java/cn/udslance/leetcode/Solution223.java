package cn.udslance.leetcode;

/**
 * @title: 矩形面积
 * @description: 给你 二维 平面上两个 由直线构成且边与坐标轴平行/垂直 的矩形，请你计算并返回两个矩形覆盖的总面积。
 * @difficulty: Medium
 * @Link: <a href="https://leetcode.cn/problems/rectangle-area/">...</a>
 * @author: Udslance
 * @create: 2023-02-18 15:37
 **/
class Solution223 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int regularSize = (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1);
        int x = Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1));
        int y = Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));
        return regularSize - x * y;
    }
}
