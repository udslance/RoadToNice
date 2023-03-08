package cn.udslance.leetcode;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

/**
 * @title: 搜索二维矩阵
 * @description: 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。
 * @difficulty: Medium
 * @Link: <a href="https://leetcode.cn/problems/search-a-2d-matrix/">...</a>
 * @author: Udslance
 * @create: 2022-10-09 23:11
 **/
class Solution074 {

    private static final Logger LOGGER = Logger.getLogger("");

    @Test
    public void testUrAnswer() {
        long startTime = System.currentTimeMillis();
        int[][] ints = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        // do something!

        String res = searchMatrix(ints, 3) + "";
        LOGGER.debug("运行结果：" + res);
        // end
        long endTime = System.currentTimeMillis();
        LOGGER.info("程序运行时间：" + (endTime - startTime) + " ms");
    }


    public boolean searchMatrix(int[][] matrix, int target) {
        // 首先通过二分查找判断可能在哪一行
        // 然后通过二分查找判断是否在这一行
        int left = 0;
        int right = matrix.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (target > matrix[mid][0]) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        int level = left;

        left = 0;
        right = matrix[0].length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == matrix[level][mid]) {
                return true;
            } else if (target > matrix[level][mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return matrix[level][left] == target;
    }
}
