package cn.udslance.leetcode;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

/**
 * @Title:
 * @Difficulty:
 * @Link: <a href="">...</a>
 * @author H
 *
 */
class Solution852 {
    static Logger logger = Logger.getLogger("");
    @Test
    public void test() {
        long startTime = System.currentTimeMillis();
        //do something
        long endTime = System.currentTimeMillis();
        logger.info("程序运行时间：" + (endTime - startTime) + " ms");
    }

    public int peakIndexInMountainArray(int[] arr) {
        int length = arr.length;
        // 特殊情况1：数组只有一个数
        if (length < 2) {
            return 0;
        }
        // 特殊情况2：左端满足要求
        if (arr[0] > arr[1]) {
            return 0;
        }
        // 特殊情况3：右端满足要求
        if (arr[length - 1] > arr[length - 2]) {
            return length - 1;
        }
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                // 判断mid满不满足
                return mid;
            } else if (arr[mid] < arr[mid + 1]) {
                // 说明mid ～ right之间有峰值
                left = mid;
            } else {
                // 说明mid ～ right之间有峰值
                right = mid;
            }
        }
        return left;
    }
}
