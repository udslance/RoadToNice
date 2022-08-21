package cn.udslance.knowledge.sort;

/**
 * @program: RoadToNice
 * @description:
 * @author: Udslance
 * @create: 2022-08-21 09:52
 **/
public class HeapTest {
    /**
     * 堆排序
     * @param arr
     */
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 基础部分：先通过数组构建大根堆
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        // 获取heapSize
        int heapSize = arr.length;
        // 0位置与heapSize位置交换，将最大者放到最后去
        // 同时缩小heapSize，每次都用heapify来选拔堆中的最大者，然后放到最后去
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }
    /**
     * 往堆中加入一个数，依旧满足大根堆
     * i位置左子节点：2 * i + 1
     * i位置右子节点：2 * i + 2
     * i位置父节点：(i - 1) / 2
     * @param arr
     * @param index
     */
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    /**
     * 堆化
     * @param arr
     * @param index
     * @param heapSize
     */
    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            // 当下方还有孩子的时候，两个孩子上谁的值大，把下标给largest
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            // 父节点和子节点中大的上位
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                // 如果依旧是父节点大，则无需继续
                break;
            }
            // 交换
            swap(arr, largest, index);
            // 刷新指针
            index = largest;
            left = index * 2 + 1;
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
