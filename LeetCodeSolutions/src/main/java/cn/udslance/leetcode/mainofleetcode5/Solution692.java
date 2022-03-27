package cn.udslance.leetcode.mainofleetcode5;



import java.util.*;

/**
 * 前K个高频单词
 * https://leetcode-cn.com/problems/top-k-frequent-words/
 * @author H
 * @create 2021-08-23 9:21
 */
public class Solution692 {
    
    public void test() {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        System.out.println(topKFrequent(words, k));
    }

    /**
     * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
     * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
     * @param words 单词列表
     * @param k 前 k 个出现次数最多的单词
     * @return ...
     */
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freqMap = new HashMap<>();

        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        List<String>[] buckets = new List[words.length];

        for (int i = 0; i < words.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            buckets[entry.getValue()].add(entry.getKey());
        }


        List<String> resList = new ArrayList<>();

        for (int i = words.length - 1; i >= 0 && resList.size() < k; i--) {
            if (buckets[i].isEmpty()) {
                continue;
            }
            Collections.sort(buckets[i]);
            for (int j = 0; j < buckets[i].size() && resList.size() < k; j++) {
                resList.add(buckets[i].get(j));
            }
        }



        return resList;
    }
}
