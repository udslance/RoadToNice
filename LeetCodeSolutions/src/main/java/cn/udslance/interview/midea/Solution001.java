package cn.udslance.interview.midea;

import java.util.ArrayList;
import java.util.List;

/**
 * @author H
 * @create 2021-09-17 20:02
 */
class Solution001 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param n int整型 总人数
     * @param m int整型 最大报数值
     * @return int整型
     */
    public int playNum (int n, int m) {
        // write code here
        //
        List<Integer> list = new ArrayList<>(n);

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int pre = 0;


        while (list.size() > 1) {
            pre = (pre + m - 1) % list.size();
            list.remove(pre);
        }

        return list.get(0);
    }

    
    public void test() {
        playNum(3, 3);
    }
}
