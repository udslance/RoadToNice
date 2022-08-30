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
public class Solution {
    static Logger logger = Logger.getLogger("");
    @Test
    public void test() {
        long startTime = System.currentTimeMillis();
        //do something
        long endTime = System.currentTimeMillis();
        logger.info("程序运行时间：" + (endTime - startTime) + " ms");
    }
}
