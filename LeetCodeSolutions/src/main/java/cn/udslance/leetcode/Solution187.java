package cn.udslance.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @title: 重复的DNA序列
 * @description: 给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的 长度为 10 的序列(子字符串)。你可以按 任意顺序 返回答案。
 * @difficulty: Medium
 * @Link: <a href="https://leetcode.cn/problems/repeated-dna-sequences/description/">...</a>
 * @author: Udslance
 * @create: 2022-11-10 22:30
 **/
class Solution187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        int n = s.length();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i + 10 <= n; i++) {
            String cur = s.substring(i, i + 10);
            int cnt = map.getOrDefault(cur, 0);
            if (cnt == 1) {
                ans.add(cur);
            }
            map.put(cur, cnt + 1);
        }
        return ans;
    }
}
