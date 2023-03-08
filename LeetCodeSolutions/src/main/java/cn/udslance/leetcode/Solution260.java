package cn.udslance.leetcode;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

/**
 * @author H
 * @Title: 只出现一次的数字III
 * @Difficulty: medium
 * @Link: <a href="">...</a>
 */
class Solution260 {
    static Logger logger = Logger.getLogger("");

    @Test
    public void test() {
        long startTime = System.currentTimeMillis();
        //do something
        long endTime = System.currentTimeMillis();
        logger.info("程序运行时间：" + (endTime - startTime) + " ms");
    }

    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int eor = nums[0];
        for (int i = 1; i < nums.length; i++) {
            eor = eor ^ nums[i];
        }
        // eor = a ^ b != 0
        // eor必有一个位置是1
        // 提取出最右侧的1
        int rightOne = eor & (~eor + 1);
        int onlyOne = 0;
        for (int num : nums) {
            if ((num & rightOne) == 0) {
                onlyOne ^= num;
            }
        }
        res[0] = onlyOne;
        res[1] = eor ^ onlyOne;
        return res;
    }
}
