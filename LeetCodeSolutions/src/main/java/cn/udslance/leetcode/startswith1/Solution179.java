package cn.udslance.leetcode.startswith1;


import org.junit.jupiter.api.Test;

/**
 * @author H
 * @create 2021-08-03 20:38
 */
public class Solution179 {
    @Test
    public void test() {
        int[] nums = {3,30,34,5,9};
        System.out.println(largestNumber(nums));
    }

    public String largestNumber(int[] nums) {
        //每次都找最大的
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = nums[i] + "";
        }
        quickSort(strings, 0, nums.length - 1);
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : strings) {
            stringBuilder.append(string);
        }
        String res = stringBuilder.toString();
        if (res.startsWith("0")) {
            return "0";
        }
        return res;
    }

    /**
     * 快速排序
     *
     * @param strings ...
     * @return ...
     */
    private void quickSort(String[] strings, int left, int right) {
        if (left >= right) {
            return;
        }
        int l = left, r = right;
        String p = strings[left];
        while (true) {
            while (l < r && (strings[r] + p).compareTo(p + strings[r]) <= 0) {
                // 找一个应该放到p左边去的数
                r--;
            }
            while (l < r && (strings[l] + p).compareTo(p + strings[l]) >= 0) {
                // 找一个应该放到p右边去的数
                l++;
            }
            if (l >= r) {
                break;
            }
            String temp = strings[l];
            strings[l] = strings[r];
            strings[r] = temp;
        }
        strings[left] = strings[l];
        strings[l] = p;
        quickSort(strings, left, l - 1);
        quickSort(strings, l+1, right);
    }
}
