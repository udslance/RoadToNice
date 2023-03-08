package cn.udslance.interview.xiecheng;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author H
 * @create 2021-09-09 19:02
 */
public class XieChen003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] l1 = br.readLine().trim().split(" ");
        //接下来 m 行，每行两个空格隔开的正整数k, x，为消除连续的k个1可以获得的分数x
        int m = Integer.parseInt(l1[1]);
        String[] l2 = br.readLine().trim().split("0");
        List<Integer> input = new ArrayList<>();
        //获取每段连续 1 的长度
        for (String s : l2) {
            if (s.length() != 0) {
                input.add(s.length());
            }
        }
        // 初始化得分细则
        int[] sizes = new int[m];
        int[] values = new int[m];
        for (int i = 0; i < m; i++) {
            String[] tmp = br.readLine().trim().split(" ");
            sizes[i] = Integer.parseInt(tmp[0]);
            values[i] = Integer.parseInt(tmp[1]);
        }
        solution(input,sizes,values);
    }

    public static void solution(List<Integer> input, int[] sizes, int[] values) {
        int sum = 0;
        for (Integer integer : input) {
            sum += method1(integer, sizes.length, sizes, values);
        }
        System.out.println(sum);
    }


    /**
     * 背包问题
     */
    public static int method1(int maxWeights,int count, int[] weights, int[] values) {
        int[][] table = new int[count + 1][maxWeights + 1];
        //初始化第一列
        for (int i = 0; i < table.length; i++) {
            table[i][0] = 0;
        }
        //初始化第一行
        Arrays.fill(table[0], 0);
        for (int i = 1; i < table.length; i++) {
            for (int j = 1; j < table[0].length; j++) {

                if (weights[i - 1] > j) {
                    table[i][j] = table[i - 1][j];
                } else {
                    table[i][j] = Math.max(table[i - 1][j], values[i - 1] + table[i][j - weights[i - 1]]);
                }
            }
        }
        return table[count][maxWeights];

    }
}
