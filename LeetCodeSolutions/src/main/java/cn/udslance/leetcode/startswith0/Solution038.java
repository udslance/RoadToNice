package cn.udslance.leetcode.startswith0;


/**
 * @author H
 * @create 2021-06-29 23:14
 */
public class Solution038 {
    public void test() {
        System.out.println(countAndSay(5));

    }

    public String countAndSay(int n) {
        String[] strings = new String[n + 1];
        strings[1] = "1";
        //首先要将字符串分割为最小数量的组，每个组都由连续的最多相同字符组成
        for (int i = 2; i < strings.length; i++) {
            char[] chars = strings[i - 1].toCharArray();
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < chars.length; j++) {
                int count = 1;
                while (j < chars.length - 1 && chars[j] == chars[j + 1]) {
                    count++;
                    j++;
                }
                stringBuilder.append(count);
                stringBuilder.append(chars[j]);
            }
            strings[i] = stringBuilder.toString();
        }
        return strings[n];
    }
}
