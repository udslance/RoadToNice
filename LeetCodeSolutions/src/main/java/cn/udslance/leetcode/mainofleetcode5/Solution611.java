package cn.udslance.leetcode.mainofleetcode5;



import java.util.Arrays;

/**
 * 有效三角形的个数
 * https://leetcode-cn.com/problems/valid-triangle-number/
 * @author H
 * @create 2021-08-04 19:05
 */
public class Solution611 {
    
    public void test() {
        int[] ints = new int[]{2, 2, 3, 4};

        System.out.println(triangleNumber(ints));

    }

    public int triangleNumber(int[] nums) {
        //首先对数组排序。
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n - 2; ++i) {
            for (int j = i + 1; j < n - 1; ++j) {
                /*
                 * 固定最短的两条边，二分查找最后一个小于两边之和的位置。
                 * 可以求得固定两条边长之和满足条件的结果。
                 * 枚举结束后，总和就是答案。
                 */
                int s = nums[i] + nums[j];
                int l = j + 1, r = n - 1;
                while (l < r) {
                    int mid = l + r + 1 >>> 1;
                    if (nums[mid] < s) {
                        l = mid;
                    } else {
                        r = mid - 1;
                    }
                }
                //最后一个小于两边之和的位置。
                if (nums[r] < s) {
                    res += r - j;
                }
            }
        }
        return res;
    }
}
