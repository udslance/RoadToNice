package cn.udslance.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author H
 * @create 2021-06-13 10:15
 */
class Solution228 {
    public static void main(String[] args) {
        int[] nums = {0};

        Solution228 solution228 = new Solution228();

        List<String> res = solution228.summaryRanges(nums);

        for (String re : res) {
            System.out.println(re);
        }

    }

    public List<String> summaryRanges(int[] nums) {



        List<String> res = new ArrayList<>();

        if (nums.length == 0) {
            return res;
        }

        for (int start = 0; start < nums.length;) {
            if (start + 1 == nums.length || nums[start + 1] != nums[start] + 1) {
                //如果start指向最后一个，或者start不连续
                res.add("" + nums[start]);
                start++;
            } else{
                //start和他后面的一个连起来了
                int end = start + 1;
                while (end + 1 < nums.length && nums[end] + 1 == nums[end + 1]) {
                    end++;
                }
                res.add(nums[start] + "->" + nums[end]);

                start = end + 1;
            }
        }
        return res;
    }
}
