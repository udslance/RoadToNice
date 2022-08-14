package cn.udslance.leetcode.startswith3;



/**
 * https://leetcode-cn.com/problems/valid-perfect-square/solution/zhi-xing-yong-shi-0-ms-zai-suo-you-c-ti-jiao-zh-44/
 * @author H
 * @create 2021-08-23 9:21
 */
public class Solution367 {
    public boolean isPerfectSquare(int num) {
        int tmp = 1;
        while (num > 0) {
            num -= tmp;
            tmp += 2;
        }

        return num == 0;
    }
    
    public void test() {
        long startTime = System.currentTimeMillis();
        //do something
        System.out.println(isPerfectSquare(14));
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
}
