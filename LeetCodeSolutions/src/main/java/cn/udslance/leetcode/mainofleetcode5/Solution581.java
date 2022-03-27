package cn.udslance.leetcode.mainofleetcode5;



import java.util.Stack;

/**
 * @author H
 * @create 2021-08-23 9:21
 */
public class Solution581 {
    
    public void test() {
        System.out.println(findUnsortedSubarray(new int[]{2,1}));
    }

    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> indexStack = new Stack<>();

        int[] res = new int[]{Integer.MAX_VALUE, -1};

        for (int i = 0; i < nums.length; i++) {
            if (indexStack.isEmpty() || nums[indexStack.peek()] <= nums[i]) {
                indexStack.push(i);
                continue;
            }
            Stack<Integer> list = new Stack<>();
            while (!indexStack.isEmpty() && nums[indexStack.peek()] > nums[i]) {
                list.push(indexStack.pop());
            }
            indexStack.push(i);
            res[1] = Math.max(res[1], i);
            while (!list.isEmpty()) {
                int temp = list.pop();
                indexStack.push(temp);
                res[0] = Math.min(res[0], temp);
            }
        }

        return res[1] == -1 ? 0 : res[1] - res[0] + 1;
    }
}
