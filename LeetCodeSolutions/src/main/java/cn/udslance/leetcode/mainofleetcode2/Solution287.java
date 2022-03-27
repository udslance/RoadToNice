package cn.udslance.leetcode.mainofleetcode2;



/**
 * @author H
 * @create 2021-08-16 20:27
 */
public class Solution287 {


    public void test() {
        System.out.println(findDuplicate(new int[]{1,3,4,2,2}));
    }

    public int findDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            // 根据抽屉原理，小于等于 4 的个数如果严格大于 4 个，此时重复元素一定出现在 [1..4] 区间里
            if (count > mid) {
                // 重复元素位于区间 [left..mid]
                right = mid;
            } else {
                // if 分析正确了以后，else 搜索的区间就是 if 的反面区间 [mid + 1..right]
                left = mid + 1;
            }
        }

        return left;
    }

}
