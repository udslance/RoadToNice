package cn.udslance.leetcode.mainofleetcode2;



/**
 * 数组中的第K个最大元素
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 *
 * @author H
 * @create 2021-08-10 19:59
 */
public class Solution215 {


    public void test() {
        int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};


        System.out.println(findKthLargest(nums, 4));

    }

    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0];
        }
        // 最后一个参数表示我们要找的是下标为k-1的数
        return quickSearch(nums, 0, nums.length - 1, k - 1);
    }

    private int quickSearch(int[] nums, int left, int right, int k) {
        // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
        int j = quickSort(nums, left, right);
        if (j == k) {
            return nums[j];
        }
        // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
        return j > k ? quickSearch(nums, left, j - 1, k) : quickSearch(nums, j + 1, right, k);

    }

    private int quickSort(int[] nums, int left, int right) {


        int l = left, r = right;
        int pivot = nums[left];

        while (true) {
            //从右边开始，找一个比pivot大的数
            while (l < r && nums[r] <= pivot) {
                r--;
            }

            while (l < r && nums[l] >= pivot) {
                l++;
            }

            if (l >= r) {
                break;
            }

            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }

        nums[left] = nums[l];
        nums[l] = pivot;

        return l;
    }
}
