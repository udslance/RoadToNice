package cn.udslance.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author H
 * @create 2021-08-23 9:21
 */
class Solution523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        //使用 HashSet 来保存出现过的值。
        //让循环从 2 开始枚举右端点（根据题目要求，子数组长度至少为 2），每次将符合长度要求的位置的取余结果存入 HashSet。
        //如果枚举某个右端点 j 时发现存在某个左端点 i 符合要求【使得 sum[j] 和 sum[i−1] 对 k 取余相同。】，则返回 True。
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            set.add(sum[i - 2] % k);
            if (set.contains(sum[i] % k)) {
                return true;
            }
        }
        return false;
    }

    public void test() {
        long startTime = System.currentTimeMillis();
        //do something
        int[] nums = {23, 2, 6, 4, 7};
        System.out.println(checkSubarraySum(nums, 13));
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
}
