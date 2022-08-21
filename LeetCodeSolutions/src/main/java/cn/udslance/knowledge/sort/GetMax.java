package cn.udslance.knowledge.sort;

/**
 * @program: RoadToNice
 * @description: 运用递归找最大值
 * @author: Udslance
 * @create: 2022-08-15 23:14
 **/
public class GetMax {
    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }
        int mid = left + ((right - left) >> 1);
        int leftMax = process(arr, left, mid);
        int rightMax = process(arr, mid + 1, right);
        return Math.max(leftMax, rightMax);
    }
}
