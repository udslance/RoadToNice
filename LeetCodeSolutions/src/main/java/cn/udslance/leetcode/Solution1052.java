package cn.udslance.leetcode;

/**
 * 爱生气的书店老板
 * https://leetcode-cn.com/problems/grumpy-bookstore-owner/
 * @author H
 * @create 2021-08-23 9:21
 */
class Solution1052 {
    
    public void test() {
        int[] customers = {1,0,1,2,1,1,7,5};
        int[] grumpy = {0,1,0,1,0,1,0,1};
        int minutes = 3;
        System.out.println(maxSatisfied(customers, grumpy, minutes));
    }

    /**
     *
     * @param customers 每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开
     * @param grumpy  如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0
     * @param minutes 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
     * @return 这一天营业下来，最多有多少客户能够感到满意。
     */
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        //如果老板整天都不用这个技能，那满意的顾客是最少的
        int satisfy = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                satisfy += customers[i];
            }
        }

        //angry 记录所有因为老板生气而不满意的顾客
        int[] angry = new int[customers.length];
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 1) {
                angry[i] = customers[i];
            }
        }

        //在 angry 中维护一个大小为 minutes 的窗口，窗口中的总和就是老板使用技能能弥补的不满意顾客数量
        int makeUp = 0;
        //初始化窗口
        for (int i = 0; i < minutes; i++) {
            makeUp += angry[i];
        }
        //更新老板使用技能能弥补的最好情况
        int maxMakeUp = makeUp;
        for (int i = minutes; i < angry.length; i++) {
            makeUp += angry[i];
            makeUp -= angry[i - minutes];
            maxMakeUp = Math.max(maxMakeUp, makeUp);
        }

        return satisfy + maxMakeUp;
    }
}
