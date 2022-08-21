package cn.udslance.knowledge.example;

import org.junit.jupiter.api.Test;

/**
 * @program: RoadToNice
 * @description:
 * @author: Udslance
 * @create: 2022-08-18 23:07
 **/
public class LittleSum {

    @Test
    public void test() {
        littleSum();
    }

    public void littleSum() {
        System.out.println(process(new int[]{1,2,3,4,5},0,4));
    }

    public int process(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }

        int mid = l + ((r - l) >> 1);
        return process(arr, l, mid) + process(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    public int merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        int res = 0;
        while (p1 <= mid && p2 <= right) {
            res += arr[p1] < arr[p2] ? arr[p1] * (right - p2 + 1) : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= right) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[left + j] = help[j];
        }
        return res;
    }

}
