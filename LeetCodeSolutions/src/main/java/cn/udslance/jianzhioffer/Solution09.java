package cn.udslance.jianzhioffer;

/**
 * @author H
 * @create 2021-05-12 16:37
 */
class Solution09 {


    int count = 0;

    
    public void test() {


        System.out.println(translateNum(12258));
    }

    /**
     * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成
     * “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不
     * 同的翻译方法。
     * @param num
     * @return
     */

    public int translateNum(int num) {
        String str = "" + num;
        //str = "12258"

        int[] dp = new int[str.length()];

        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            //如果这个数字跟上一位的和大于25，则加上这位数字只会增加一种翻译方式
            boolean b = Integer.parseInt(str.substring(i - 1, i + 1)) <= 25 && Integer.parseInt(str.substring(i - 1, i + 1)) >= 10;
            if (b && i == 1) {
                dp[i] = dp[i - 1] + 1;
            } else if (b) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[str.length() - 1];
    }


}
