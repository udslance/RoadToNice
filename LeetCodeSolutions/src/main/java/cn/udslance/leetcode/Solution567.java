package cn.udslance.leetcode;

import java.util.Arrays;

/**
 * 字符串的排列
 * https://leetcode-cn.com/problems/permutation-in-string/
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 *
 * @author H
 * @create 2021-08-22 20:31
 */
class Solution567 {
    public void test() {
        System.out.println(checkInclusion("adc", "dcda"));
    }

    public boolean checkInclusion(String s1, String s2) {
        char[] s11 = s1.toCharArray();
        char[] s22 = s2.toCharArray();
        int n1 = s1.length();
        int n2 = s2.length();
        if (n2 < n1) {
            return false;
        }
        int[] counter1 = new int[26];
        int[] counter2 = new int[26];
        int left = 0;
        int right = n1 - 1;
        for (int i = 0; i < n1; i++) {
            counter1[s11[i] - 'a']++;
        }
        for (int i = 0; i < n1 - 1; i++) {
            counter2[s22[i] - 'a']++;
        }
        while (right < n2) {
            counter2[s22[right] - 'a']++;
            if (Arrays.equals(counter1, counter2)) {
                return true;
            } else {
                counter2[s22[left] - 'a']--;
                if (counter2[s22[left] - 'a'] < 0) {
                    counter2[s22[left] - 'a'] = 0;
                }
                left++;
                right++;
            }
        }
        return false;
    }
}
