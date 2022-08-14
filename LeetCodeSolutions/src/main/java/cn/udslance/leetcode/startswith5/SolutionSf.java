package cn.udslance.leetcode.startswith5;



/**
 * @author H
 * @create 2021-08-23 9:21
 */
public class SolutionSf {

    public boolean solution(int k) {
        // k = a * 11 + b * 111
        if (k % 111 == 0) {
            // k是111的整数倍  -> 直接返回
            return true;
        }

        // k不是111的整数倍 -> 从大到小尝试 b 的可能性。
        for (int b =  k / 111; b >= 0; b--) {
            if ((k - b * 111) % 11 == 0) {
                return true;
            }
        }

        return false;
    }
    
    public void test() {
        long startTime = System.currentTimeMillis();
        //do something
        System.out.println(solution(965));
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
}
