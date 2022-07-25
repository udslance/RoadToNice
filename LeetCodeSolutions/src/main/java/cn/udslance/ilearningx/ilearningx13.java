package cn.udslance.ilearningx;

import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @program: RoadToNice
 * @description: 给定一个设备编号区间[start, end]，包含4或18的编号都不能使用，如：418、148、718不能使用，108可用。
 * @author: Udslance
 * @create: 2022-07-14 17:25
 **/
public class ilearningx13 {

    public static void main(String[] args) {
        int[] array1 = new int[]{1 ,4, 7, 11, 17};
        int[] array2 = new int[]{2, 4, 6, 9, 20};
        int pairTarget = 3;

        System.out.println(getMinSum(array1, array2, pairTarget));
    }

    //给定两个整数数组array1、array2，数组元素按升序排列。假设从array1、array2中分别选择一个元素可构成一个元素对。
    //
    //现在需要找出 k 个元素对，并分别对这些元素对求和（两个值相加），请计算这些和的累加值的最小值。
    private static int getMinSum(int[] array1, int[] array2, int pairTarget) {
        // 在此补充你的代码
        // 每个数组各搭配一个指针
        int res = 0;

        List<Integer> sums = new ArrayList<>();

        for (int i : array1) {
            for (int i1 : array2) {
                sums.add(i + i1);
            }
        }
        Integer[] tmp = new Integer[sums.size()];
        sums.toArray(tmp);
        Arrays.sort(tmp);

        for (int i = 0; i < pairTarget; i++) {
            res += tmp[i];
        }
        return res;
    }

}
