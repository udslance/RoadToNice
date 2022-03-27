package cn.udslance.leetcode.mainofleetcode5;



import java.util.LinkedList;
import java.util.Queue;

/**
 * @author H
 * @create 2021-08-23 9:21
 */
public class Solution542 {
    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return mat;
        }

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        int[] dx = new int[] {-1, 1, 0, 0};
        int[] dy = new int[] {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0], y = point[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                // 如果四邻域的点是 -1，表示这个点是未被访问过的 1
                // 所以这个点到 0 的距离就可以更新成 mat[x][y] + 1。
                if (newX >= 0 && newX < mat.length && newY >= 0 && newY < mat[0].length
                        && mat[newX][newY] == -1) {
                    mat[newX][newY] = mat[x][y] + 1;
                    queue.offer(new int[] {newX, newY});
                }
            }
        }

        return mat;

    }
    
    public void test() {
        long startTime = System.currentTimeMillis();
        //do something
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
}
