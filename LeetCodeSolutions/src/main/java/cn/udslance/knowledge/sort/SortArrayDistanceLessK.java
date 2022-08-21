package cn.udslance.knowledge.sort;

import java.util.PriorityQueue;

/**
 * @program: RoadToNice
 * @description:
 * @author: Udslance
 * @create: 2022-08-21 11:14
 **/
public class SortArrayDistanceLessK {
    public void sortedArrDistanceLessK(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        for (; index < Math.min(arr.length, k); index++) {
            heap.add(arr[index]);
        }
        int i = 0;
        for (; index < arr.length; i++, index++) {
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }
        while (!heap.isEmpty()) {
            arr[i++] = heap.poll();
        }
    }
}
