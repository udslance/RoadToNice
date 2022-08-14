package cn.udslance.knowledge.sort;

/**
 * @program: RoadToNice
 * @description: 选择排序
 * @author: Udslance
 * @create: 2022-08-13 23:48
 **/
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        // 特殊情况
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            // i ~ N - 1 上找最小值的下标
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }
    /**
     * 交换
     * @param arr 原始数组
     * @param i 索引1
     * @param j 索引2
     */
    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
