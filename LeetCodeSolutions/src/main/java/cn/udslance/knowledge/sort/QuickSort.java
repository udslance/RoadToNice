package cn.udslance.knowledge.sort;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author H
 * @create 2021-08-03 21:59
 */
public class QuickSort {
    @Test
    public void test() {
        int[] nums = new int[]{3, 4, 5, 1, 2, 22, 33, 12, 0, 9, -1};
        quickSort(nums, 0, nums.length - 1);

        System.out.println(Arrays.toString(nums));

    }

    private void quickSort(int[] nums, int left, int right) {
        //递归终止条件
        if (left >= right) {
            return;
        }
        //ml 为本次递归中移动的左指针，mr 为本次递归中移动的右指针
        int ml = left, mr = right;
        //以left指向的值作为标尺
        int ruler = nums[left];
        while (true) {
            // 如果以nums[left]作为标尺，那么应当先从相反的方向，即右端开始找
            // 期间需要不断判断 ml 和 mr 的相对大小
            while (ml < mr && nums[mr] >= ruler) {
                mr--;
            }

            //然后再从左端开始找
            while (ml < mr && nums[ml] <= ruler) {
                ml++;
            }
            //循环终止条件
            if (ml >= mr) {
                break;
            }
            int temp1 = nums[ml];
            nums[ml] = nums[mr];
            nums[mr] = temp1;
        }

        //现在ml指向标尺应当放置的位置，把标尺放过去
        nums[left] = nums[ml];
        nums[ml] = ruler;

        //递归排序
        //快速排序可以理解为每次递归确定一个值的位置，即 标尺 的位置，所以下次递归就不用囊括已经确定的 标尺 了
        quickSort(nums, left, ml - 1);
        quickSort(nums, ml + 1, right);
    }

    public static void quickSort3(int[] arr, int left, int right) {
        if (left < right) {
            // 从数组中间随机抽取一个数，交换到右边界去
            swap(arr, left + (int) (Math.random() * (right - left + 1)), right);
            int[] p = partition(arr, left, right);
            // 去 < 区递归
            quickSort3(arr, left, p[0] - 1);
            // 去 > 区递归
            quickSort3(arr, p[1] + 1, right);
        }
    }

    /**
     * 这是一个处理arr[left……right]的函数
     * 默认以arr[right]为标尺作为划分一句，划分为小于部分——等于部分——大于部分
     *
     * @param arr
     * @param left
     * @param right
     * @return 返回等于区域（左边界，右边界），所以返回一个长度为2的数组res
     */
    public static int[] partition(int[] arr, int left, int right) {
        // <区右边界
        int less = left - 1;
        // >区左边界
        int more = right;
        // 荷兰国旗思路，left表示当前数的位置，arr[right]划分值
        while (left < more) {
            if (arr[left] < arr[right]) {
                // 当前数 < 划分值
                swap(arr, ++less, left++);
            } else if (arr[left] > arr[right]) {
                // 当前数 > 划分值
                swap(arr, --more, left);
            } else {
                // 当前数 = 划分值
                left++;
            }
        }
        // 最终明确了标尺位置，将arr[right]放入
        swap(arr, more, right);
        return new int[]{less + 1, more};
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
