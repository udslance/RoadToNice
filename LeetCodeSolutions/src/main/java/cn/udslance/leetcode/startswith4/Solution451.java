package cn.udslance.leetcode.startswith4;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author H
 * @create 2021-08-23 9:21
 */
public class Solution451 {
    
    public void test() {
        System.out.println(frequencySort("eeeee"));
    }

    public String frequencySort(String s) {
        //首先统计各字符出现频率
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        List<Character>[] lists = new List[s.length() + 1];

        for (int i = 0; i < s.length() + 1; i++) {
            lists[i] = new ArrayList<>();
        }

        //然后放进桶里
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            lists[entry.getValue()].add(entry.getKey());
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = lists.length - 1; i >= 0; i--) {
            if (lists[i] == null || lists[i].size() == 0) {
                continue;
            }
            for (Character character : lists[i]) {
                for (int j = 0; j < i; j++) {
                    stringBuilder.append(character);
                }
            }
        }

        return stringBuilder.toString();
    }
}
