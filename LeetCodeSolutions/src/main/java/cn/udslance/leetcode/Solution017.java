package cn.udslance.leetcode;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author H
 * @Title: 电话号码的字母组合
 * @Difficulty: Middle
 * @Link: <a href="https://leetcode.cn/problems/letter-combinations-of-a-phone-number/">...</a>
 */
class Solution017 {
    static Logger logger = Logger.getLogger("");

    @Test
    public void test() {
        long startTime = System.currentTimeMillis();
        //do something
        List<String> res = letterCombinations("23");
        logger.info(res);
        long endTime = System.currentTimeMillis();
        logger.info("程序运行时间：" + (endTime - startTime) + " ms");
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        Map<Character, Character[]> dic = new HashMap<>(8);

        dic.put('2', new Character[]{'a', 'b', 'c'});
        dic.put('3', new Character[]{'d', 'e', 'f'});
        dic.put('4', new Character[]{'g', 'h', 'i'});
        dic.put('5', new Character[]{'j', 'k', 'l'});
        dic.put('6', new Character[]{'m', 'n', 'o'});
        dic.put('7', new Character[]{'p', 'q', 'r', 's'});
        dic.put('8', new Character[]{'t', 'u', 'v'});
        dic.put('9', new Character[]{'w', 'x', 'y', 'z'});

        List<Character[]> list = new ArrayList<>();

        for (int i = 0; i < digits.length(); i++) {
            list.add(dic.get(digits.charAt(i)));
        }

        StringBuilder path = new StringBuilder();
        dfs(list, 0, digits, 0, path, res);
        return res;
    }

    /**
     *
     * @param list 查询表
     * @param cur 当前位置
     * @param digits 存放的是用户按的数字
     * @param curDepth 当前长度
     * @param path 当前字符串
     * @param res 结果集
     */
    private void dfs(List<Character[]> list, int cur, String digits, int curDepth, StringBuilder path,List<String> res) {
        // 终止条件：长度够了
        if (curDepth == digits.length()) {
            //StringBuilder 的 toString() 方法会 new 一个对象
            res.add(path.toString());
            return;
        }

        for (int i = 0; i < list.get(cur).length; i++) {
            //往 path 加一个在 dictionary 里查到的字符
            path.append(list.get(cur)[i]);
            //递归添加
            dfs(list, cur + 1, digits, curDepth + 1, path, res);
            //需要回溯
            path.deleteCharAt(path.length() - 1);
        }
    }
}
