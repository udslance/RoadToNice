package cn.udslance.leetcode.startswith5;



import java.util.*;

/**
 * @author H
 * @create 2021-08-23 9:21
 */
public class Solution763 {
    
    public void test() {
        List<Integer> res = partitionLabels("ababcbacadefegdehijhklij");

        System.out.println(res);

    }

    public List<Integer> partitionLabels2(String s) {
        Stack<Set<Integer>> stack = new Stack<>();

        //存放每个字符第一次出现的索引
        int[] drct = new int[26];
        Arrays.fill(drct, -1);

        for (int i = 0; i < s.length(); i++) {
            String tmpStr = s.substring(i, i + 1);
            char tmpChar = s.charAt(i);
            if (drct[tmpChar - 'a'] == -1) {
                //说明第一次碰到
                drct[tmpChar - 'a'] = i;
                Set<Integer> set = new HashSet<>();
                set.add(i);
                stack.push(set);
            } else {
                //前面有，获取到第一次出现的坐标
                int firstIndex = drct[tmpChar - 'a'];
                Set<Integer> set = new HashSet<>();
                set.add(i);
                //在栈中找到这个坐标
                while (!stack.peek().contains(firstIndex)) {
                    set.addAll(stack.pop());
                }
                stack.peek().addAll(set);
            }
            //加入 stringSet 方便以后判断是否有
        }

        List<Integer> res = new ArrayList<>();

        while (!stack.isEmpty()) {
            res.add(stack.pop().size());
        }

        for (int i = 0; i < res.size() / 2; i++) {
            int tmp = res.get(i);
            res.set(i, res.get(res.size() - 1 - i));
            res.set(res.size() - 1 - i, tmp);
        }

        return res;
    }

    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        int length = s.length();
        //存放各字符最后一次出现的位置
        for (int i = 0; i < length; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<Integer>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            //每个片段访问结束的标志是访问到下标 end
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }
}
