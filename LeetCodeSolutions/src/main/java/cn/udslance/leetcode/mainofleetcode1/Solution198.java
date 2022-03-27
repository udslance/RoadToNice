package cn.udslance.leetcode.mainofleetcode1;


/**
 * 打家劫舍
 * https://leetcode-cn.com/problems/house-robber/
 * @author H
 * @create 2021-08-04 20:20
 */
public class Solution198 {
    
    public void test() {
        int[] nums = {2,7,9,3,1};

        System.out.println(rob(nums));
    }


    public int rob(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        ////首先确定是从0起跳还是从1起跳
        ////从[1]起跳，那必须是[1]的价值大于[0] + [2]
        //int start = 0;
        //if (nums[1] > nums[0] + nums[2]) {
        //    start = 1;
        //}
        //
        //int res = nums[start];
        //int end = nums.length - 1;
        //
        ////下一步位置
        //int next = start + 2;
        //while (next < nums.length) {
        //    //下一步默认去隔1间的，如果要去隔2间的，必须满足[start + 3] > [start + 2] + [start + 4]
        //    if (next == end) {
        //        //下一步就是最后一家了，没得选了
        //        res += nums[next];
        //        break;
        //    }
        //
        //    if (next == end - 1) {
        //        //下一步是倒数第二家，那要比较一下
        //        if (nums[next + 1] > nums[next]) {
        //            next++;
        //        }
        //        res += nums[next];
        //        break;
        //    }
        //
        //    if (nums[next + 1] > nums[next] + nums[next + 2]) {
        //        next++;
        //    }
        //
        //    res += nums[next];
        //    next += 2;
        //}


        return dfs(nums, 0, 0);
    }

    private int dfs(int[] nums, int sum, int start) {
        if (start >= nums.length) {
            return 0;
        }

        sum = sum + nums[start];

        sum += Math.max(dfs(nums,sum , start + 2), dfs(nums, sum, start + 3));


        return sum;
    }
}
