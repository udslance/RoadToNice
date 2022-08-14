package cn.udslance.leetcode.startswith2;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author H
 * @create 2021-08-23 9:21
 */
public class Solution227 {
    
    public void test() {
        System.out.println(calculate(" 3+5*2 +1"));

    }

    /**
     * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
     *
     * @param s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
     * @return ...
     */
    // 使用 map 维护一个运算符优先级
    // 这里的优先级划分按照「数学」进行划分即可
    Map<Character, Integer> map = new HashMap<Character, Integer>(){{
        put('-', 1);
        put('+', 1);
        put('*', 2);
        put('/', 2);
        put('%', 2);
        put('^', 3);
    }};

    public int calculate(String s) {
        // 将所有的空格去掉
        s = s.replaceAll(" ", "");
        char[] cs = s.toCharArray();
        int n = s.length();

        // 存放所有的数字
        Deque<Integer> nums = new ArrayDeque<>();

        // 为了防止第一个数为负数，先往 nums 加个 0
        nums.addLast(0);
        // 存放所有「非数字以外」的操作
        Deque<Character> ops = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char c = cs[i];
            if (c == '(') {
                ops.addLast(c);
            } else if (c == ')') {
                // 计算到最近一个左括号为止
                while (!ops.isEmpty()) {
                    if (ops.peekLast() != '(') {
                        calc(nums, ops);
                    } else {
                        //把左括号弹出
                        ops.pollLast();
                        break;
                    }
                }
            } else {
                if (isNumber(c)) {
                    int num = 0;
                    int j = i;
                    // 将从 i 位置开始后面的连续数字整体取出，加入 nums
                    while (j < n && isNumber(cs[j])) {
                        num = num * 10 + (cs[j++] - '0');
                    }
                    nums.addLast(num);
                    //多走了一步，退一步
                    i = j - 1;
                } else {
                    if (i > 0 && (cs[i - 1] == '(' || cs[i - 1] == '+' || cs[i - 1] == '-')) {
                        nums.addLast(0);
                    }
                    // 有一个新操作要入栈时，先把栈内可以算的都算了
                    // 只有满足「栈内运算符」比「当前运算符」优先级高/同等，才进行运算
                    while (!ops.isEmpty() && ops.peekLast() != '(') {
                        char prev = ops.peekLast();
                        if (map.get(prev) >= map.get(c)) {
                            calc(nums, ops);
                        } else {
                            break;
                        }
                    }
                    ops.addLast(c);
                }
            }
        }
        // 将剩余的计算完
        while (!ops.isEmpty()) {
            calc(nums, ops);
        }
        return nums.peekLast();
    }
    void calc(Deque<Integer> nums, Deque<Character> ops) {
        if (nums.isEmpty() || nums.size() < 2) {
            return;
        }
        if (ops.isEmpty()) {
            return;
        }
        int b = nums.pollLast(), a = nums.pollLast();
        char op = ops.pollLast();
        int ans = 0;
        if (op == '+') {
            ans = a + b;
        } else if (op == '-') {
            ans = a - b;
        } else if (op == '*') {
            ans = a * b;
        } else if (op == '/') {
            ans = a / b;
        } else if (op == '^') {
            ans = (int)Math.pow(a, b);
        } else if (op == '%') {
            ans = a % b;
        }
        nums.addLast(ans);
    }
    boolean isNumber(char c) {
        return Character.isDigit(c);
    }
}
