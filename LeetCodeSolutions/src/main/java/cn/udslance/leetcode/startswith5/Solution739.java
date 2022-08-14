package cn.udslance.leetcode.startswith5;



import java.util.Stack;

/**
 * @author H
 * @create 2021-08-12 20:34
 */
public class Solution739 {


    public void test() {
        System.out.println(dailyTemperatures(new int[]{73,74,75,71,69,72,76,73}));
    }


    public int[] dailyTemperatures(int[] temperatures) {

        if(temperatures.length == 0){
            return temperatures;
        }

        Stack<Integer> helper = new Stack<>();

        int[] res = new int[temperatures.length];

        helper.push(0);

        for (int i = 1; i < temperatures.length;) {

            if (helper.isEmpty() || temperatures[i] <= temperatures[helper.peek()]) {
                helper.push(i);
                i++;
            }else {
                int loc = helper.pop();
                res[loc] = i - loc;
            }

        }

        return res;
    }
}
