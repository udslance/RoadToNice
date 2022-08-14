package cn.udslance.knowledge.search;

import org.junit.jupiter.api.Test;

/**
 * @program: RoadToNice
 * @description:
 * @author: Udslance
 * @create: 2022-08-14 23:05
 **/
public class DivideSearch {

    /**
     * 最基础的二分查找
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        //通过二分查找寻找顶点
        int left = 0, right = nums.length - 1;
        while (left < right) {
            // important
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    /**
     * 寻找有序数组中大于等于某值的最左索引
     * @param arr 含有重复数字的有序数组
     * @return
     */
    public int findMin2(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    @Test
    public void test() {
        int[] ints = new int[]{1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 5, 5, 5};
        int target = 1;
        System.out.println(findMin2(ints,target));
    }
}
