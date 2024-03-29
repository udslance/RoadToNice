package cn.udslance.leetcode;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

/**
 * @Title: 最长公共前缀
 * @Difficulty: Easy
 * @Link: <a href="https://leetcode.cn/problems/longest-common-prefix/">link</a>
 * @author H
 *
 */
class Solution014 {
    static Logger logger = Logger.getLogger("");
    @Test
    public void test() {
        long startTime = System.currentTimeMillis();
        //do something
        String[] strings = new String[]{"a"};
        logger.info(longestCommonPrefix(strings));
        long endTime = System.currentTimeMillis();
        logger.info("程序运行时间：" + (endTime - startTime) + " ms");
    }

    public String longestCommonPrefix(String[] strs) {
        // 用第一个来做判断标准
        String firstOne = strs[0];
        int max = firstOne.length();

        for (String str : strs) {
            while (!str.startsWith(firstOne.substring(0, max))) {
                max--;
            }
            if (max == 0) {
                return "";
            }
        }

        return firstOne.substring(0, max);
    }
}
