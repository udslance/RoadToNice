package cn.udslance.leetcode.mainofleetcode2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author H
 * @create 2021-06-12 9:21
 */
public class Solution242 {
    public static void main(String[] args) {
        Solution242 solution242 = new Solution242();

        System.out.println(solution242.isAnagram("rat", "car"));
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);

            if (!map.containsKey(c)) {
                return false;
            } else {
                map.put(c, map.get(c) - 1);
            }

            if (map.get(c) < 0) {
                return false;
            }
        }

        return true;
    }
}
