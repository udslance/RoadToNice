package cn.udslance.leetcode.startswith5;



import java.util.ArrayList;
import java.util.List;

/**
 * @author H
 * @create 2021-08-12 21:41
 */
public class Solution994 {

    public void test() {
        int[][] grid = {{0,2}};
        System.out.println(orangesRotting(grid));
    }

    public int orangesRotting(int[][] grid) {
        //第一轮，遍历grid，记录烂橘子位置以及新鲜橘子数量
        List<int[]> badList = new ArrayList<>(9);

        int good = 0;
        int day = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    //烂橘子，记录位置
                    badList.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    //好橘子，记录数量
                    ++good;
                }
            }
        }

        while (!badList.isEmpty()) {
            if (good == 0) {
                break;
            }

            ++day;
            int count = badList.size();

            for (int i = 0; i < count; i++) {
                int[] badLoc = badList.remove(0);

                //上
                if (badLoc[0] - 1 >= 0 && grid[badLoc[0] - 1][badLoc[1]] == 1) {
                    //没越界并且是好橘子
                    //腐烂他！
                    grid[badLoc[0] - 1][badLoc[1]] = 2;
                    badList.add(new int[]{badLoc[0] - 1, badLoc[1]});
                    --good;
                }
                //下
                if (badLoc[0] + 1 < grid.length && grid[badLoc[0] + 1][badLoc[1]] == 1) {
                    //没越界并且是好橘子
                    //腐烂他！
                    grid[badLoc[0] + 1][badLoc[1]] = 2;
                    badList.add(new int[]{badLoc[0] + 1, badLoc[1]});
                    --good;
                }
                //左
                if (badLoc[1] - 1 >= 0 && grid[badLoc[0]][badLoc[1] - 1] == 1) {
                    //没越界并且是好橘子
                    //腐烂他！
                    grid[badLoc[0]][badLoc[1] - 1] = 2;
                    badList.add(new int[]{badLoc[0], badLoc[1] - 1});
                    --good;
                }
                //右
                if (badLoc[1] + 1 < grid[0].length && grid[badLoc[0]][badLoc[1] + 1] == 1) {
                    //没越界并且是好橘子
                    //腐烂他！
                    grid[badLoc[0]][badLoc[1] + 1] = 2;
                    badList.add(new int[]{badLoc[0], badLoc[1] + 1});
                    --good;
                }
            }


        }

        return good == 0 ? day : -1;
    }
}
