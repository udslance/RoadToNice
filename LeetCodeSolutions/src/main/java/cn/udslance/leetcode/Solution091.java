package cn.udslance.leetcode;

/**
 * @author H
 * @create 2021-07-17 16:39
 */
class Solution091 {
    
    public void test() {
        System.out.println(numDecodings("2101"));
    }
    
    public int numDecodings(String s) {
        if (s.startsWith("0")) {
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            int tmp = Integer.parseInt(s.substring(i - 1, i + 1));
            //如果这个数字跟上一位的组合大于 26 或者小于 10，则加上这位数字只会增加一种翻译方式
            boolean flagA = tmp > 10 && tmp <= 26;
            //如果这个数字跟上一位的组合等于 20 或者等于 10
            boolean flagB = tmp == 10 || tmp == 20;
            //如果这个数字跟上一位的组合为其他整十
            if (!flagB && tmp % 10 == 0) {
                return 0;
            }
            if (flagB && i == 1) {
                dp[i] = 1;
            } else if (flagB) {
                //能与前位形成 10 或者 20，则他要霸占前位 组合形式 = 与前位配合
                dp[i] = dp[i - 2];
            } else if (flagA && i == 1) {
                dp[i] = 2;
            } else if (flagA) {
                //与前位能形成配合，则 组合形式 = 不与前位配合 + 与前位配合
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                //与前位不能形成配合，则 组合形式 = 不与前位配合
                dp[i] = dp[i - 1];
            }
        }
        return dp[s.length() - 1];
    }
}
