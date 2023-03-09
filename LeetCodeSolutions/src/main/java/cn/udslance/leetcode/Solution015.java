package cn.udslance.leetcode;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Title: 三数之和
 * @Difficulty: Middle
 * @Link: <a href="https://leetcode.cn/problems/3sum/">link</a>
 * @author H
 *
 */
class Solution015 {
    static Logger logger = Logger.getLogger("");
    @Test
    public void test() {
        long startTime = System.currentTimeMillis();
        //do something
        long endTime = System.currentTimeMillis();
        logger.info("程序运行时间：" + (endTime - startTime) + " ms");
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        // 特殊情况处理
        if (nums.length < 3) {
            return resList;
        }
        // 排序
        Arrays.sort(nums);

        for (int start = 0; start < nums.length; start++) {
            // 当前基点已大于0，无需继续
            if (nums[start] > 0) {
                return resList;
            }
            // 出现重复，跳过
            if (start > 0 && nums[start] == nums[start - 1]) {
                continue;
            }
            // 定义左右指针
            int left = start + 1;
            int right = nums.length - 1;
            while (left < right) {
                int curSum = nums[start] + nums[left] + nums[right];
                if (curSum == 0) {
                    List<Integer> tmpList = new ArrayList<>();
                    tmpList.add(nums[start]);
                    tmpList.add(nums[left]);
                    tmpList.add(nums[right]);
                    resList.add(tmpList);
                    // 左指针的下一位跟他重复了,跳过，去除重复解
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // 右指针的下一位跟他重复了,跳过，去除重复解
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (curSum < 0) {
                    //若和小于 0，说明 nums[L] 太小，L 右移
                    left++;
                } else {
                    //若和大于 0，说明 nums[R] 太大，R 左移
                    right--;
                }
            }
        }
        return resList;
    }

}
