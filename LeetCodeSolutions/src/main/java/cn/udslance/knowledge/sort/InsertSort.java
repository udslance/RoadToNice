package cn.udslance.knowledge.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @program: RoadToNice
 * @description: 插入排序
 * @author: Udslance
 * @create: 2022-08-14 22:40
 **/
public class InsertSort {

    @Test
    public void test() {
        int[] arr = new int[]{1, 5, 2, 4, 5, 6, 2, 3};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
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
