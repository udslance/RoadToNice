package cn.udslance.leetcode.startswith2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author H
 * @create 2021-06-10 20:00
 */
public class Solution205 {
    public static void main(String[] args) {

        Solution205 solution205 = new Solution205();

        System.out.println(solution205.isIsomorphic("paier", "title"));

    }

    public boolean isIsomorphic(String s, String t) {
        return isIsomorphicHelper(s, t) && isIsomorphicHelper(t, s);
    }

    public boolean isIsomorphicHelper(String s, String t) {
        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char cS = s.charAt(i);
            char cT = t.charAt(i);

            if (!map.containsKey(cS)) {
                map.put(cS, cT);
            } else if (map.get(cS) != cT) {
                return false;
            }
        }

        return true;

    }
}
