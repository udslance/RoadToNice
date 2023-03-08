package cn.udslance;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

/**
 * @Title:
 * @Difficulty:
 * @Link: <a href="">...</a>
 * @author H
 *
 */
class Solution {
    private static final Logger LOGGER = Logger.getLogger("");
    @Test
    public void testUrAnswer() {
        long startTime = System.currentTimeMillis();
        //do something
        long endTime = System.currentTimeMillis();
        LOGGER.info("程序运行时间：" + (endTime - startTime) + " ms");
    }
}
