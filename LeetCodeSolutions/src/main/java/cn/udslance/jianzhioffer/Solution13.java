package cn.udslance.jianzhioffer;



import java.util.Arrays;

/**
 * @author H
 * @create 2021-05-18 14:41
 */
public class Solution13 {

    public void test() {
        int[] ints = {1, 2, 3, 4, 5};

        int[] ans = constructArr(ints);

        System.out.println(Arrays.toString(ans));
    }


    public int[] constructArr(int[] a) {
        int[] right = new int[a.length];
        int[] left = new int[a.length];

        int[] res = new int[a.length];

        right[a.length - 1] = 1;
        left[0] = 1;

        for (int i = 1; i < a.length; i++) {
            left[i] = left[i - 1] * a[i - 1];
        }

        for (int i = a.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i + 1];
        }

        for (int i = 0; i < a.length; i++) {
            res[i] = left[i] * right[i];
        }

        return res;
    }
}
