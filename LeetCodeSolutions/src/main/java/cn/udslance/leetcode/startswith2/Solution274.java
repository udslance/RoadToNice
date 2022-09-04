package cn.udslance.leetcode.startswith2;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


/**
 * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h指数。
 * 根据维基百科上 h 指数的定义：h 代表“高引用次数”，一名科研人员的 h 指数是指他（她）的 （n 篇论文中）总共有 h 篇论文
 * 分别被引用了至少 h 次。且其余的 n - h篇论文每篇被引用次数不超过 h 次。
 * 如果 h 有多种可能的值，h 指数 是其中最大的那个。
 * @Title: H 指数
 * @Difficulty: Medium
 * @Link: <a href="https://leetcode.cn/problems/h-index/">...</a>
 * @author H
 *
 */
public class Solution274 {
    static Logger logger = Logger.getLogger("");
    @Test
    public void test() {
        long startTime = System.currentTimeMillis();
        int[] citations = new int[]{3,0,6,1,5};
        //do something
        System.out.println(hIndex(citations));
        long endTime = System.currentTimeMillis();
        logger.info("程序运行时间：" + (endTime - startTime) + " ms");
    }

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int length = citations.length;
        int hI = 0;
        for (int i = length - 1; i >= 0; i--) {
            int curCit = citations[i];
            int satis = length - i;
            int curH = Math.min(satis, curCit);
            hI = Math.max(hI, curH);
        }
        return hI;
    }
}
