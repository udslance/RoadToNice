package cn.udslance.interview.meituan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author H
 * @create 2021-09-07 15:33
 */
public class MeiTuan008 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strings = br.readLine().trim().split(" ");
        //小美书架有N行编号1到N
        int N = Integer.parseInt(strings[0]);
        //书本编号从1到M
        int M = Integer.parseInt(strings[1]);
        //接下来有Q个操作
        int Q = Integer.parseInt(strings[2]);
        int[][] coms = new int[Q][3];

        for (int i = 0; i < Q; i++) {
            String[] temp = br.readLine().trim().split(" ");
            for (int j = 0; j < temp.length; j++) {
                coms[i][j] = Integer.parseInt(temp[j]);
            }
        }

        solution(N, M, Q, coms);
    }

    /**
     * 第一行两个正整数N，M，Q，表示小美书架有N行编号1到N，书本编号从1到M，接下来有Q个操作
     * 
     * 接下来Q行，每行是下列操作中的一种：
     * 
     * 1 x y : x是书本的编号，y是书架的行编号，代表小美将编号为x的书本放置到y行上。若该书本在小团手上则放置无效，若原来该书在书架上且原行上锁则放置无效，若该书被放置到一个锁了的行上则放置无效。
     * 
     * 2 y : y是书架的行编号，代表小美将行编号为y的书架加锁，对已经上锁的书架行该操作无效。
     * 
     * 3 y : y是书架的行编号，代表小美将行编号为y的书架锁去掉，对无锁的书架行该操作无效。
     * 
     * 4 x : x是书本的编号，代表小团想借编号为x的书本，对该操作若可以借到输出一行正整数在哪一行，借不到输出一行-1
     * 
     * 5 x : x是书本的编号，代表小团还回来编号为x的书本。若该书本不在小团手上该操作无效。
     */
    public static void solution(int N, int M, int Q, int[][] coms) {
        //初始化一个书架，索引为书的编号，值为行号
        Map<Integer, Integer> bookMap = new HashMap<>();
        //记录所有被锁定的行号
        Set<Integer> locked = new HashSet<>();
        //记录小团手上的书，索引为书的编号，0代表没有，1代表有
        Map<Integer, Integer> tuanMap = new HashMap<>();

        for (int[] com : coms) {
            //第一个位置代表命令的类型
            int type = com[0];
            if (type == 1) {
                // 1 x y : x是书本的编号，y是书架的行编号，代表小美将编号为x的书本放置到y行上。
                // 若该书本在小团手上则放置无效
                // 若原来该书在书架上 且 原行上锁则放置无效
                // 若该书被放置到一个锁了的行上则放置无效。
                // 排除上述三种情况
                int x = com[1];
                int y = com[2];
                if (tuanMap.getOrDefault(x, 0) == 1 || locked.contains(bookMap.get(x)) || locked.contains(y)) {
                    continue;
                }
                bookMap.put(x, y);
                continue;
            }

            if (type == 2) {
                // 2 y : y是书架的行编号，代表小美将行编号为y的书架加锁，对已经上锁的书架行该操作无效。
                int y = com[1];
                locked.add(y);
                continue;
            }

            if (type == 3) {
                // 3 y : y是书架的行编号，代表小美将行编号为y的书架锁去掉，对无锁的书架行该操作无效。
                int y = com[1];
                locked.remove(y);
                continue;
            }

            if (type == 4) {
                //4 x : x是书本的编号，代表小团想借编号为x的书本，对该操作若可以借到输出一行正整数在哪一行，借不到输出一行-1
                int x = com[1];
                int y = bookMap.getOrDefault(x, 0);
                //如果书架上没有这本书，或者行被锁了，就借不到
                if (y == 0 || locked.contains(y)) {
                    System.out.println(-1);
                    continue;
                }

                System.out.println(y);
                bookMap.put(x, 0);
                tuanMap.put(x, 1);

                continue;
            }

            if (type == 5) {
                //5 x : x是书本的编号，代表小团还回来编号为x的书本。若该书本不在小团手上该操作无效。
                int x = com[1];
                tuanMap.put(x, 0);
            }
        }
    }
}
