package cn.udslance.jianzhioffer;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，
 * 可以看成任意数字。A 不能视为 14。
 * @author H
 * @create 2021-05-18 9:12
 */
public class Solution11 {


    
    public void test() {
        int[] nums = {0,0,2,2,5};

        System.out.println(isStraight(nums));
    }

    public boolean isStraight(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for(int num : nums) {
            if(num == 0) {
                // 跳过大小王
                continue;
            }
            // 最大牌
            max = Math.max(max, num);
            // 最小牌
            min = Math.min(min, num);
            if(repeat.contains(num)) {
                // 若有重复，提前返回 false
                return false;
            }
            // 添加此牌至 Set
            repeat.add(num);
        }
        return max - min < 5;
    }

    public int lastRemaining(int n, int m) {
        //在 remove() 上 ArrayList 要比 LinkedList 快
        ArrayList<Integer> list = new ArrayList<>(n);

        //把 0 ~ n - 1 都放进list里面
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int idx = 0;

        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }

        return list.get(0);
    }
}
