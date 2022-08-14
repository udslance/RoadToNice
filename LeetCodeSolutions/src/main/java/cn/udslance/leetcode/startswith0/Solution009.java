package cn.udslance.leetcode.startswith0;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;


/**
 * @Title:
 * @Difficulty:
 * @Link:
 * @author H
 *
 */
public class Solution009 {
    static Logger logger = Logger.getLogger("");
    @Test
    public void test() {
        long startTime = System.currentTimeMillis();
        //do something
        long endTime = System.currentTimeMillis();
        logger.info("程序运行时间：" + (endTime - startTime) + " ms");
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String s = x + "";

        for (int i = 0, j = s.length() - 1; ; i++, j--) {
            if (i >= j) {
                return true;
            }
            char left = s.charAt(i);
            char right = s.charAt(j);

            if (left != right) {
                return false;
            }
        }
    }
}
