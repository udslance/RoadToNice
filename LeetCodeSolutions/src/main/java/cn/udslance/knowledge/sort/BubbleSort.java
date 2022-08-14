package cn.udslance.knowledge.sort;

/**
 * @program: RoadToNice
 * @description: 冒泡排序
 * @author: Udslance
 * @create: 2022-08-13 23:48
 **/
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        // 特殊情况
        if (arr == null || arr.length < 2) {
            return;
        }
        // 由于每次循环之后，最后一位肯定是当次选出的最大的，所以下一次可以少遍历一个
        for (int e = arr.length - 1; e > 0; e--) {
            for (int i = 0; i < e; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
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
