package cn.udslance.jianzhioffer;

import java.util.Arrays;

/**
 * @author H
 * @create 2021-05-10 9:51
 */
class Solution06 {
    public static void main(String[] args) {
        Solution06 solution06 = new Solution06();

        int[] arr = {4,5,1,6,2,7,3,8};
        System.out.println(Arrays.toString(solution06.getLeastNumbers(arr, 4)));

    }
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 最后一个参数表示我们要找的是下标为k-1的数
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    private int[] quickSearch(int[] nums, int lo, int hi, int k) {
        // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
        int j = partition(nums, lo, hi);
        if (j == k) {
            return Arrays.copyOf(nums, j + 1);
        }
        // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
        return j > k? quickSearch(nums, lo, j - 1, k): quickSearch(nums, j + 1, hi, k);
    }

    /**
     * 快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。
     * @param nums 需要切分的数组
     * @param lo 左边界
     * @param hi 右边界
     * @return 返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。
     */
    private int partition(int[] nums, int lo, int hi) {
        int v = nums[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (++i <= hi && nums[i] < v) {
                ;
            }
            // 此时nums[i]是一个大于等于v的数，或者超出边界

            while (--j >= lo && nums[j] > v) {
                ;
            }
            // 此时nums[j]是一个小于等于v的数，或者超出边界

            if (i >= j) {
                break;
            }

            // nums[j] 和 nums[i]
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
        nums[lo] = nums[j];
        nums[j] = v;
        return j;
    }
}
