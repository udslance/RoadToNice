package cn.udslance.leetcode;

/**
 * 删除有序数组中的重复项
 * @author H
 * @create 2021-06-04 9:12
 */
class Solution026 {
    public static void main(String[] args) {
        System.out.println("你好 jdk11");
    }

    
    public void test(){
        System.out.println("你好 jdk11");
    }

    /**
     * 双指针交换法
     * @param nums 含有重复数字的数组
     * @return 数组中不同数字的数量
     */
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int p = 0;
        int q = 1;
        while(q < nums.length){
            if(nums[p] != nums[q]){
                nums[p + 1] = nums[q];
                p++;
            }
            q++;
        }
        return p + 1;
    }
}
