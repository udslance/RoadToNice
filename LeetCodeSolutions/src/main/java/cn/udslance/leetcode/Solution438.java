package cn.udslance.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author H
 * @create 2021-08-23 9:21
 */
class Solution438 {

    @Test
    public void test() {
        System.out.println(findAnagrams("abab", "ab"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        int[] drctP = new int[26];
        int[] drctS = new int[26];
        List<Integer> res = new ArrayList<>();

        if (s.length() < p.length()) {
            return res;
        }
        for (char c : p.toCharArray()) {
            drctP[c - 'a']++;
        }
        char[] sChar = s.toCharArray();
        for (int i = 0; i < p.length(); i++) {
            drctS[sChar[i] - 'a']++;
        }

        for (int i = p.length(); i < s.length(); i++) {
            if (Arrays.equals(drctP, drctS)) {
                res.add(i - p.length());
            }
            drctS[sChar[i] - 'a']++;

            drctS[sChar[i - p.length()] - 'a']--;
        }
        if (Arrays.equals(drctP, drctS)) {
            res.add(s.length() - p.length());
        }
        return res;
    }
}
