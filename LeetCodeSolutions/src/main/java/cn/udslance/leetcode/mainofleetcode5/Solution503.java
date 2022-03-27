package cn.udslance.leetcode.mainofleetcode5;



import java.util.Arrays;
import java.util.Stack;

/**
 * @author H
 * @create 2021-08-22 22:09
 */
public class Solution503 {

    public void test() {
        int[] res = nextGreaterElements(new int[]{1,2,3,4,3});

        System.out.println(Arrays.toString(res));

    }


    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res,-1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            while (!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return res;
    }
}
