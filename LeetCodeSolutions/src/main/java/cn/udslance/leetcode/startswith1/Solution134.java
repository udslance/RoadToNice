package cn.udslance.leetcode.startswith1;


/**
 * @author H
 * @create 2021-07-26 20:44
 */
public class Solution134 {

    public void test() {
        int[] gas = {2, 4};
        int[] cost = {3, 4};
        System.out.println(canCompleteCircuit(gas,cost));
    }
    /**
     * gas  = [1,2,3,4,5]
     * cost = [3,4,5,1,2]
     * @param gas 第 i 个加油站有汽油 gas[i] 升。
     * @param cost 从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int res = -1;

        //1. 如果在起点加的油都不够跑到下个加油站，就不可行

        for (int i = 0; i < gas.length; i++) {
            if (gas[i] < cost[i]) {
                continue;
            }

            int curGas = 0;
            int curLoc = i;

            //记录能往后面走几站
            int count = 0;

            while (count < gas.length) {


                curGas += gas[curLoc];
                curGas -= cost[curLoc];

                if (curGas < 0) {
                    break;
                }

                curLoc = (curLoc + 1) % gas.length;
                count++;


            }


            if (curLoc == i) {
                res = i;
            } else if (count + i >= gas.length) {
                break;
            } else {
                //执行跳跃
                i = curLoc;
            }


        }

        return res;

    }
}
