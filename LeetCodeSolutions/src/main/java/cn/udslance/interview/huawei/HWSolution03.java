package cn.udslance.interview.huawei;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 最大子矩阵
 * @author H
 * @create 2021-08-25 18:45
 */
public class HWSolution03 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("E:\\360MoveData\\Users\\Administrator\\Desktop"));

        int n = in.nextInt();
        int m = in.nextInt();
        int[][] input = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                input[i][j] = in.nextInt();
            }
        }
        System.out.println(solution1(input));

    }

    public static int solution1(int[][] input) {
        //如果前面的数对他有正影响，则带上，如果是负影响，则舍弃
        //先计算总和
        for (int[] ints : input) {
            System.out.println(Arrays.toString(ints));
        }
        int[][] total = input;
        for (int i = 1; i < input[0].length; i++) {
            for (int j = 0; j < input.length; j++) {
                total[i][j] += total[i-1][j];
            }
        }

        int maximum = Integer.MIN_VALUE;
        for (int i = 0; i < input.length; i++) {
            for (int j = i; j < input.length; j++) {
                //result 保存的是从 i 行 到第 j 行 所对应的矩阵上下值的和  
                int[] result = new int[input[0].length];
                for (int f = 0; f < input[0].length; f++) {
                    if (i == 0) {
                        result[f] = total[j][f];
                    } else {
                        result[f] = total[j][f] - total[i - 1][f];
                    }
                }
                int maximal = maxSubsequence(result);

                if (maximal > maximum) {
                    maximum = maximal;
                }
            }
        }

        return maximum;

    }

    public static int maxSubsequence(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int[] maxSub = new int[array.length];
        maxSub[0] = array[0];

        for (int i = 1; i < array.length; i++) {
            maxSub[i] = (maxSub[i-1] > 0) ? (maxSub[i-1] + array[i]) : array[i];
            if (max < maxSub[i]) {
                max = maxSub[i];
            }
        }
        return max;
    }
}
