package cn.udslance.leetcode;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * @Title:
 * @Difficulty:
 * @Link: <a href="">link</a>
 * @author H
 *
 */
class SolutionH1 {
    private static final Logger LOGGER = Logger.getLogger("");
    @Test
    public void testUrAnswer() {
        long startTime = System.currentTimeMillis();
        //do something
        long endTime = System.currentTimeMillis();
        LOGGER.info("程序运行时间：" + (endTime - startTime) + " ms");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 生命数
        int M = scanner.nextInt();
        // 吊桥长度
        int N = scanner.nextInt();
        // 缺失木板树
        int K = scanner.nextInt();
        // 桥梁数组，缺失位置为1，可行位置为0，0位置为起点，端点位置为终点
        boolean[] bridge = new boolean[N+2];
        for (int i = 0; i < K; i++) {
            bridge[scanner.nextInt()] = true;
        }
        dfs(M, 0, N + 2, bridge);
        if (bridge.length <= 4) {
            res -= M;
        }
        System.out.println(res - 1);
    }
    static int res = 0;
    private static void dfs(int curHp,int loc, int target, boolean[] bridge) {
        if (loc > target || curHp <= 0) {
            return;
        }
        if (loc == target) {
            res += 1;
            return;
        }
        if (bridge[loc]) {
            dfs(curHp - 1, loc + 1, target, bridge);
            dfs(curHp - 1, loc + 2, target, bridge);
            dfs(curHp - 1, loc + 3, target, bridge);
        } else {
            dfs(curHp, loc + 1, target, bridge);
            dfs(curHp, loc + 2, target, bridge);
            dfs(curHp, loc + 3, target, bridge);
        }
    }

    private static int superMario(int M, int N, int K, boolean[] bridge) {
        // 定义到达位置i，生命值为j的方法数为dp(i,j)
        int[][] dp = new int[bridge.length][M + 1];
        // 起点设置为1
        for (int i = 0; i < M + 1; i++) {
            dp[0][i] = 1;
        }
        // 从上到下，从左到右遍历
        for (int i = 1; i < bridge.length; i++) {
            for (int j = 1; j < M + 1; j++) {
                // 如果可以从i-1跳过来
                if (i - 1 >= 0) {
                    if (bridge[i - 1]) {
                        // 如果i-1是陷阱，还想保持j条命的话，则在i-1的时候就必须多一条命
                        if (j + 1 < M + 1) {
                            dp[i][j] += dp[i - 1][j + 1];
                        }
                    } else {
                        dp[i][j] += dp[i - 1][j];
                    }
                }
                // 如果可以从i-2跳过来
                if (i - 2 >= 0) {
                    if (bridge[i - 2]) {
                        // 如果i-2是陷阱，还想保持j条命的话，则在i-2的时候就必须多一条命
                        if (j + 1 < M + 1) {
                            dp[i][j] += dp[i - 2][j + 1];
                        }
                    } else {
                        dp[i][j] += dp[i - 2][j];
                    }
                }
                // 如果可以从i-3跳过来
                if (i - 3 >= 0) {
                    if (bridge[i - 3]) {
                        // 如果i-3是陷阱，还想保持j条命的话，则在i-3的时候就必须多一条命
                        if (j + 1 < M + 1) {
                            dp[i][j] += dp[i - 3][j + 1];
                        }
                    } else {
                        dp[i][j] += dp[i - 3][j];
                    }
                }
            }
        }
        int res = 0;
        for (int i = 1; i < M + 1; i++) {
            res += dp[bridge.length - 1][i];
        }
        // 不能一步从起点到终点，所以要减掉可能的情况
        if (bridge.length <= 4) {
            res -= M;
        }
        return res;
    }
}
