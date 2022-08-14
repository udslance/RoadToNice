package cn.udslance.leetcode.startswith5;



import java.util.Arrays;

/**
 * @author H
 * @create 2021-08-03 21:59
 */
public class SortTest {
    
    public void test() {
        int[] nums = new int[]{3, 4, 5, 1, 2,22,33,12,0,9,-1};
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
        quickSort(nums, ml+1, right);
    }
}
