package cn.udslance.interview.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author H
 * @create 2021-08-23 9:21
 */
public class HWSolution05 {
    /*
     * 200块 分解成零钱 50 20 10 5 每种至少一张。分解成20张，总共有多少组合，每种零钱有多少张。
     * 200 -85 = 115
     */

    public void solution() {
        List<int[]> res = new ArrayList<>();
        //组合
        int[] path = new int[4];
        Arrays.fill(path, 1);
        //面额
        int[] coins = new int[]{5, 10, 20, 50};
        dfs(res, coins, path, 115, 0, 0);

        System.out.println(res.size());
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }
    }

    private void dfs(List<int[]> res, int[] coins, int[] path, int target, int sum, int start) {
        if (target == 0) {
            if (sum == 16) {
                int[] temp = path.clone();
                res.add(temp);
            }
            return;
        }

        for (int i = start; i < coins.length; i++) {
            //判断是否应该使用这个面额
            if (target - coins[i] >= 0) {
                path[i]++;
                dfs(res, coins, path, target - coins[i], sum + 1, start);
                //回溯
                path[i]--;
            } else {
                break;
            }
        }
    }


    
    public void test() {
        long startTime = System.currentTimeMillis();
        //do something
        solution();
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
}
