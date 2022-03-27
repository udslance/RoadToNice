package cn.udslance.leetcode.mainofleetcode3;



import java.util.*;

/**
 * @author H
 * @create 2021-08-12 21:11
 */
public class Solution347 {

    public void test() {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};

        int[] ints = topKFrequent(nums, 2);

        System.out.println(Arrays.toString(ints));
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>(2 * k);
        List<Integer> resList = new ArrayList<>();

        for (int num : nums) {
            if (hashMap.containsKey(num)) {
                hashMap.put(num, hashMap.get(num) + 1);
            } else {
                hashMap.put(num, 1);
            }
        }

        List<Integer>[] lists = new List[nums.length + 1];

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (lists[entry.getValue()] == null) {
                lists[entry.getValue()] = new ArrayList<>();
            }

            lists[entry.getValue()].add(entry.getKey());
        }

        for (int i = lists.length - 1; i >= 0; i--) {
            if (lists[i] == null) {
                continue;
            }
            resList.addAll(lists[i]);
        }

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = resList.get(i);
        }

        return res;


    }

}
