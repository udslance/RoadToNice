package cn.udslance.leetcode;
import org.junit.jupiter.api.Test;

import javax.crypto.interfaces.PBEKey;
import java.security.PublicKey;
import java.util.Arrays;

/**
 * 多数元素
 * <a href="https://leetcode.cn/problems/majority-element//">...</a>
 * @author H
 * @create 2021-08-03 19:50
 */
class Solution169 {
    @Test
    public void test() {
        System.out.println(majorityElement(new int[]{3, 2, 3}));
    }

    /**
     * 从第一个数开始count=1，遇到相同的就加1，遇到不同的就减1，
     * 减到0就重新换个数开始计数，总能找到最多的那个
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int count = 1;
        int curRes = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == curRes) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                curRes = nums[i];
                count = 1;
            }
        }
        return curRes;
    }
}
