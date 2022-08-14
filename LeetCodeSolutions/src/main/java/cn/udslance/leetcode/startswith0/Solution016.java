package cn.udslance.leetcode.startswith0;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


/**
 * @Title: 最接近的三数之和
 * @Difficulty:
 * @Link: <a href="https://leetcode.cn/problems/3sum-closest/submissions/">...</a>
 * @author H
 *
 */
public class Solution016 {
    static Logger logger = Logger.getLogger("");
    @Test
    public void test() {
        long startTime = System.currentTimeMillis();
        //do something
        long endTime = System.currentTimeMillis();
        logger.info("程序运行时间：" + (endTime - startTime) + " ms");
    }

    public int threeSumClosest(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[2];

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            //出现重复，跳过这个
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                //求出三个数的和
                int temp = nums[i] + nums[left] + nums[right];

                //根据 sum = nums[i] + nums[start] + nums[end] 的结果，
                //判断 sum 与目标 target 的距离，如果更近则更新结果 ans
                if (Math.abs(target - temp) < Math.abs(target - res)) {
                    res = temp;
                }

                //如果 temp < target 则 left++
                if (temp < target) {
                    left++;
                } else if(temp > target){
                    //如果 temp > target 则 right--
                    right--;
                }else {
                    return res;
                }
            }
        }
        return res;
    }
}
