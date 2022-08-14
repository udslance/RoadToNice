package cn.udslance.leetcode.startswith5;



/**
 * @author H
 * @create 2021-08-23 9:21
 */
public class Solution1894 {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        int n = chalk.length;
        for (int i : chalk) {
            sum += i;
        }


        long rest = k % sum;
        if (rest == 0) {
            return 0;
        }

        for (int i = 0; i < n; i++) {
            rest -= chalk[i];
            if (rest < 0) {
                return i;
            }
        }

        return 0;
    }
    
    public void test() {
        long startTime = System.currentTimeMillis();
        //do something
        int[] chalk = {5, 1, 5};
        int k = 22;
        System.out.println(chalkReplacer(chalk, k));
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
}
