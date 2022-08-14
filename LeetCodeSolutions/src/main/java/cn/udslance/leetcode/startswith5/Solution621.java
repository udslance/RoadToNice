package cn.udslance.leetcode.startswith5;


import java.util.Arrays;

/**
 * @author H
 * @create 2021-08-23 9:21
 */
public class Solution621 {
    
    public void test() {
        char[] tasks = new char[]{'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'C', 'D', 'D', 'E'};
        System.out.println(leastInterval(tasks, 2));
    }

    public int leastInterval(char[] tasks, int n) {
        int[] buckets = new int[26];
        for(int i = 0; i < tasks.length; i++){
            buckets[tasks[i] - 'A']++;
        }
        Arrays.sort(buckets);
        int maxTimes = buckets[25];
        int maxCount = 1;
        for(int i = 25; i >= 1; i--){
            if(buckets[i] == buckets[i - 1]) {
                maxCount++;
            } else {
                break;
            }
        }
        int res = (maxTimes - 1) * (n + 1) + maxCount;
        return Math.max(res, tasks.length);
    }
}
