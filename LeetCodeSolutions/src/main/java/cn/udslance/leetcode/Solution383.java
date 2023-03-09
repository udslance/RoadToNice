package cn.udslance.leetcode;

/**
 * @title: 赎金信
 * @description: 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 如果可以，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * @difficulty: Easy
 * @Link: <a href="https://leetcode.cn/problems/ransom-note/">link</a>
 * @author: Udslance
 * @create: 2023-03-09 22:54
 **/
class Solution383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ran = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            int tmp = ransomNote.charAt(i) - 'a';
            ran[tmp]++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            int tmp = magazine.charAt(i) - 'a';
            ran[tmp]--;
        }
        for (int j : ran) {
            if (j > 0) {
                return false;
            }
        }
        return true;
    }
}
