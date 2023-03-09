package cn.udslance.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词拆分
 * <a href="https://leetcode-cn.com/problems/word-break/">link</a>
 * @author H
 * @create 2021-07-27 22:13
 */
class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int maxWordLength = 0;
        Set<String> wordSet = new HashSet<>(wordDict.size());
        // 将字符串列表中的单词加入到wordSet中，方便查找
        for (String word : wordDict) {
            wordSet.add(word);
            if (word.length() > maxWordLength) {
                // 记录最长单词的长度
                maxWordLength = word.length();
            }
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = (Math.max(i - maxWordLength, 0)); j < i; j++) {
                // 如果j位置之前的单词可以拆分，并且j->i的单词可以拆分，那i才算是可以拆分
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }
}
