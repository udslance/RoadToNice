package cn.udslance.interview.meituan;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * @author H
 * @create 2021-09-07 16:49
 */
public class MeiTuan010 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().trim().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);
        int d = Integer.parseInt(input[3]);
        int e = Integer.parseInt(input[4]);
        int f = Integer.parseInt(input[5]);
        int g = Integer.parseInt(input[6]);

        solution(a,b,c,d,e,f,g);
    }

    /**
     *
     * @param a 条领带 0
     * @param b 条裤子 1
     * @param c 个帽子 2
     * @param d 件衬衫 3
     * @param e 卖出一套领带加衬衫可以得到e元
     * @param f 卖出一套裤子加衬衫可以得到f元
     * @param g 卖出一套帽子加衬衫可以得到g元
     */
    public static void solution(int a, int b, int c, int d, int e, int f, int g) {
        int[] stock = {a, b, c, d};
        //优先发挥最大价值
        int[] p1 = {0, 3, e, Math.min(stock[0], stock[3])};
        int[] p2 = {1, 3, f, Math.min(stock[1], stock[3])};
        int[] p3 = {2, 3, g, Math.min(stock[2], stock[3])};
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1[2] == o2[2]) {
                return Integer.compare(o2[3], o1[3]);
            }
            return Integer.compare(o2[2], o1[2]);
        });

        priorityQueue.add(p1);
        priorityQueue.add(p2);
        priorityQueue.add(p3);


        long res = 0;
        while (!priorityQueue.isEmpty()) {
            int[] combo = priorityQueue.poll();
            res += sale(combo, stock);
        }

        System.out.println(res);
    }

    private static long sale(int[] combo, int[] stock) {
        int index0 = combo[0];
        int index1 = combo[1];
        int price = combo[2];

        int little = Math.min(stock[index0], stock[index1]);
        stock[index0] -= little;
        stock[index1] -= little;

        return (long)price * little;
    }

    
    public void test() {
        solution(2, 3, 4, 5, 6, 7, 8);
    }
}
