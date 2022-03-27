package cn.udslance.leetcode.mainofleetcode1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词拆分
 * https://leetcode-cn.com/problems/word-break/
 * @author H
 * @create 2021-07-27 22:13
 */
public class Solution139 {
    public static void main(String[] args) {
        Solution139 solution139 = new Solution139();

        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");

        solution139.wordBreak(s, wordDict);
    }


    public boolean wordBreak(String s, List<String> wordDict) {
        int maxWordLength = 0;
        Set<String> wordSet = new HashSet<>(wordDict.size());
        for (String word : wordDict) {
            wordSet.add(word);

            if (word.length() > maxWordLength) {
                maxWordLength = word.length();
            }
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = (Math.max(i - maxWordLength, 0)); j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }
}
