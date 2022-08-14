package cn.udslance.leetcode.startswith5;



/**
 * @author H
 * @create 2021-08-23 9:21
 */
public class Solution1006 {
    public int clumsy(int n) {

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = n, type = 1; i >= 1; i--, type++) {
            stringBuilder.append(i);
            switch (type) {
                case 1:
                    stringBuilder.append("*");
                    break;
                case 2:
                    stringBuilder.append("/");
                    break;
                case 3:
                    stringBuilder.append("+");
                    break;
                case 4:
                    stringBuilder.append("-");
                    type = 0;
                    break;
                default:
                    break;
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        System.out.println(stringBuilder);
        return 0;
    }
    
    public void test() {
        long startTime = System.currentTimeMillis();
        //do something
        clumsy(10);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
}
