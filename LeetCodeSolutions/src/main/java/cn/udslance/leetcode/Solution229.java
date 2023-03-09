package cn.udslance.leetcode;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @Title: 多数元素 II
 * @Difficulty: Medium
 * @Link: <a href="https://leetcode.cn/problems/majority-element-ii/">link</a>
 * @author H
 *
 */
class Solution229 {
    static Logger logger = Logger.getLogger("");
    @Test
    public void test() {
        long startTime = System.currentTimeMillis();
        //do something
        long endTime = System.currentTimeMillis();
        logger.info("程序运行时间：" + (endTime - startTime) + " ms");
    }

    /**
     * 给定一个大小为 n 的整数数组，找出其中所有出现超过n/3次的元素。
     * 有一个对摩尔投票法非常形象的比喻：多方混战。
     * 首先要知道，在任何数组中，出现次数大于该数组长度1/3的值最多只有两个。
     * 我们把这道题比作一场多方混战，战斗结果一定只有最多两个阵营幸存，其他阵营被歼灭。数组中的数字即代表某士兵所在的阵营。
     * 我们维护两个潜在幸存阵营A和B。我们遍历数组，如果遇到了属于A或者属于B的士兵，则把士兵加入A或B队伍中，该队伍人数加一。继续遍历。
     * 如果遇到了一个士兵既不属于A阵营，也不属于B阵营，这时有两种情况：
     * 1. A阵营和B阵营都还有活着的士兵，那么进行一次厮杀，参与厮杀的三个士兵全部阵亡：A阵营的一个士兵阵亡，B阵营的一个士兵阵亡，这个不知道从哪个阵营来的士兵也阵亡。继续遍历。
     * 2. A阵营或B阵营已经没有士兵了。这个阵营暂时从地球上消失了。那么把当前遍历到的新士兵算作新的潜在幸存阵营，这个新阵营只有他一个人。继续遍历。
     * 大战结束，最后A和B阵营就是初始人数最多的阵营。判断一下A，B的人数是否超过所有人数的三分之一就行了。
     * @param nums
     * @return
     */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        // 出现次数超过n/3的元素不会超过2个
        int numA = nums[0];
        int countA = 0;
        int numB = nums[0];
        int countB = 0;
        for (int num : nums) {
            if (num == numA) {
                countA++;
                continue;
            }
            if (num == numB) {
                countB++;
                continue;
            }
            if (countA == 0) {
                numA = num;
                countA++;
                continue;
            }
            if (countB == 0) {
                numB = num;
                countB++;
                continue;
            }
            countA--;
            countB--;
        }
        if (help(nums, numA)) {
            list.add(numA);
        }
        if (numA != numB) {
            if (help(nums, numB)) {
                list.add(numB);
            }
        }
        return list;
    }

    /**
     * 判断一个数在数组中出现的次数是否大于（nums.length / 3）
     * @param nums
     * @param num
     * @return
     */
    private boolean help(int[] nums, int num) {
        int count = 0;
        for (int i : nums) {
            if (i == num) {
                count++;
            }
        }
        return count > nums.length / 3;
    }
}
