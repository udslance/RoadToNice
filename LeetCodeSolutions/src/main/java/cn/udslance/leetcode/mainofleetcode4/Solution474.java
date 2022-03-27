package cn.udslance.leetcode.mainofleetcode4;



import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author H
 * @create 2021-08-23 9:21
 */
public class Solution474 {

    /**
     * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
     *
     * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
     *
     */
    public int findMaxForm(String[] strs, int m, int n) {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });
        for (String str : strs) {
            priorityQueue.offer(str);
        }

        int count = 0;


        while (m >= 0 && n >= 0) {
            int cur1 = 0;
            String tmp = priorityQueue.poll();
            int curValue = Integer.parseInt(tmp);
            while (curValue != 0) {
                if ((curValue & 1) == 1) {
                    cur1++;
                }
                curValue = curValue >> 1;
            }

            int cur0 = tmp.length() - cur1;

            m -= cur0;
            n -= cur1;

            if (n >= 0 && m >= 0) {
                count++;
            }
        }

        return count;
    }

    
    public void test() {



        long startTime = System.currentTimeMillis();

        //do something
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5;
        int n = 3;
        System.out.println(findMaxForm(strs, m, n));
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
}
