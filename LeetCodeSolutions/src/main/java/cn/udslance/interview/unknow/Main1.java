package cn.udslance.interview.unknow;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author H
 * @create 2021-06-17 20:20
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //最大重量
        int maxWeight = Integer.parseInt(in.nextLine());
        //各集装箱重量
        String[] sweights = in.nextLine().split(",");
        int[] weights = new int[sweights.length];
        for (int i = 0; i < weights.length; i++) {
            weights[i] = Integer.parseInt(sweights[i]);
        }
        //各集装箱价值
        String[] svalues = in.nextLine().split(",");
        int[] values = new int[svalues.length];
        for (int i = 0; i < values.length; i++) {
            values[i] = Integer.parseInt(svalues[i]);
        }
        Main1 main1 = new Main1();
        int res = main1.method1(maxWeight, values.length, weights, values);
        System.out.println(res);
    }


    private static final Logger LOG = Logger.getLogger("");

    @Test
    public void testUrAnswer() {
        int[] weights = {1, 4, 3};
        int[] values = {15, 30, 20};
        int maxWeights = 4;
        long startTime = System.currentTimeMillis();
        LOG.warn("运行结果：" + method1(maxWeights, weights.length, weights, values));
        long endTime = System.currentTimeMillis();
        LOG.info("程序运行时间：" + (endTime - startTime) + " ms");
    }

    /**
     *
     * @param maxWeights 货轮最大容量
     * @param count 集装箱数量
     * @param weights 货物重量
     * @param values 货物价值
     * @return 最大价值
     */
    public int method1(int maxWeights,int count, int[] weights, int[] values) {
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
                    //如果当前物品太重，放不下，只能套用上个物品的存放方案
                    table[i][j] = table[i - 1][j];
                } else {
                    // 当前物品能放下，但是要看放他是否能让价值提升
                    // table[i - 1][j]：上个物品存放方案的最大价值
                    // values[i - 1]：当前物品的价值
                    // weights[i - 1]：当前物品的重量
                    // 放下当前物品之后，剩余空间能放下的最大价值：
                    // 无限背包：table[i][j - weights[i - 1]]
                    // 01背包：table[i - 1][j - weights[i - 1]]
                    if(table[i - 1][j] < values[i - 1] + table[i][j - weights[i - 1]]){
                        table[i][j] = values[i - 1] + table[i][j - weights[i - 1]];
                    }else{
                        table[i][j] = table[i - 1][j];
                    }
                }
            }
        }

        return table[count][maxWeights];

    }
}
