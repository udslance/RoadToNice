package cn.udslance.leetcode.startswith2;



import java.util.*;

/**
 * 课程表 II
 * https://leetcode-cn.com/problems/course-schedule-ii/
 * @author H
 * @create 2021-08-09 19:53
 */
public class Solution210 {
    
    public void test() {
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};


        int[] order = findOrder(numCourses, prerequisites);

        System.out.println(Arrays.toString(order));

    }



    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 1.课号和对应的入度
        Map<Integer, Integer> inDegree = new HashMap<>();
        // 将所有的课程先放入
        for (int i = 0; i < numCourses; i++) {
            inDegree.put(i, 0);
        }
        // 2.依赖关系, 依赖当前课程的后序课程
        // 即上完key课，就可以上value中的课了
        Map<Integer, List<Integer>> adj = new HashMap<>(9);

        for (int[] prerequisite : prerequisites) {
            int base = prerequisite[1];
            int next = prerequisite[0];

            //next 的入度加一
            inDegree.put(next, inDegree.get(next) + 1);
            //将 next 存入 base 的出度中
            if (!adj.containsKey(base)) {
                adj.put(base, new ArrayList<>());
            }

            adj.get(base).add(next);
        }

        int[] res = new int[numCourses];
        int index = 0;

        // 3.BFS, 将入度为0的课程放入队列, 队列中的课程就是没有先修, 可以学的课程
        Queue<Integer> q = new LinkedList<>();
        for (int key : inDegree.keySet()) {
            if (inDegree.get(key) == 0) {
                q.offer(key);
            }
        }
        // 取出一个节点, 对应学习这门课程.
        // 遍历当前邻接表, 更新其入度; 更新之后查看入度, 如果为0, 加入到队列
        while (!q.isEmpty()) {
            int cur = q.poll();
            res[index++] = cur;
            if (index == res.length) {
                return res;
            }
            // 遍历当前课程的邻接表, 更新后继节点的入度
            if (!adj.containsKey(cur)) {
                continue;
            }


            List<Integer> successorList = adj.get(cur);

            for (int k : successorList) {
                inDegree.put(k, inDegree.get(k) - 1);
                if (inDegree.get(k) == 0) {
                    q.offer(k);
                }
            }
        }

        return new int[numCourses];

    }
}
