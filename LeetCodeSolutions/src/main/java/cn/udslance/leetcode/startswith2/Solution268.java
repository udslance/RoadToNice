package cn.udslance.leetcode.startswith2;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;


/**
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 * @Title: 丢失的数字
 * @Difficulty: Easy
 * @Link: <a href="https://leetcode.cn/problems/missing-number/">...</a>
 * @author H
 *
 */
public class Solution268 {
    static Logger logger = Logger.getLogger("");
    @Test
    public void test() {
        long startTime = System.currentTimeMillis();
        //do something
        int[] arr = new int[]{0};
        int res = missingNumber(arr);
        logger.info(res);
        long endTime = System.currentTimeMillis();
        logger.info("程序运行时间：" + (endTime - startTime) + " ms");
    }

    public int missingNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        for (int i = 0; i < nums.length; i++) {
            res ^= i;
        }
        res ^= nums.length;
        return res;
    }
}
