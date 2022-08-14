package cn.udslance.leetcode.startswith1;


/**
 * @author H
 * @create 2021-08-03 20:38
 */
public class Solution179 {

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

        help(strings, 0, nums.length - 1);

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
    private void help(String[] strings, int left, int right) {
        if (left >= right) {
            return;
        }

        int l = left, r = right;
        String p = strings[l];
        while (true) {
            while (l < r && (strings[r] + p).compareTo(p + strings[r]) <= 0) {
                r--;
            }
            while (l < r && (strings[l] + p).compareTo(p + strings[l]) >= 0) {
                l++;
            }
            if (l >= r) {
                break;
            }
            String temp = strings[l];
            strings[l] = strings[r];
            strings[r] = temp;
        }

        p = strings[l];
        strings[l] = strings[left];
        strings[left] = p;

        help(strings, left, l - 1);
        help(strings, l+1, right);
    }
}
