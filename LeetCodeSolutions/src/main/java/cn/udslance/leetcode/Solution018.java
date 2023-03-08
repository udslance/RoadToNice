package cn.udslance.leetcode;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author H
 * @Title:
 * @Difficulty:
 * @Link: <a href="">...</a>
 */
class Solution018 {
    static Logger logger = Logger.getLogger("");

    @Test
    public void test() {
        long startTime = System.currentTimeMillis();
        //do something
        int[] nums = new int[]{0, 0, 0, -1000000000, -1000000000, -1000000000, -1000000000};
        fourSum(nums, -1000000000);

        long endTime = System.currentTimeMillis();
        logger.info("程序运行时间：" + (endTime - startTime) + " ms");
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        //特殊情况
        if (nums.length < 4) {
            return resultList;
        }
        int length = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < length - 3; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏,直接跳出循环
            if (nums[i] + nums[i + 1] - target > -(nums[i + 2] + nums[i + 3])) {
                break;
            }
            // 重制target，为3数之和做准备
            int curTar = target - nums[i];
//nums[a]+nums[b]-target<-(nums[c]+nums[d])
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    //进入下一轮循环
                    continue;
                }
                //获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏,直接跳出循环
                if (nums[j] + nums[j + 1] + -curTar > -nums[j + 2]) {
                    break;
                }
                int left = j + 1;
                int right = length - 1;
                while (left < right) {
                    int sum = nums[j] + nums[left] + nums[right];
                    if (sum == curTar) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[left]);
                        tmp.add(nums[right]);
                        resultList.add(tmp);
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        // 右指针的下一位跟他重复了,跳过，去除重复解
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sum < curTar) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return resultList;
    }
}
