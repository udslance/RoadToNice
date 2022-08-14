package cn.udslance.leetcode.startswith0;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.Stack;


/**
 * @Title:
 * @Difficulty:
 * @Link: <a href="">...</a>
 * @author H
 *
 */
public class Solution020 {
    static Logger logger = Logger.getLogger("");
    @Test
    public void test() {
        long startTime = System.currentTimeMillis();
        //do something
        logger.info(isValid("{[]}"));
        long endTime = System.currentTimeMillis();
        logger.info("程序运行时间：" + (endTime - startTime) + " ms");
    }

    public boolean isValid(String s) {

        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> orgStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            orgStack.push(s.charAt(i));
        }
        Stack<Character> helper = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char curPop = orgStack.peek();
            if (curPop == '}') {
                orgStack.pop();
                helper.push('{');
                continue;
            }
            if (curPop == ']') {
                orgStack.pop();
                helper.push('[');
                continue;
            }
            if (curPop == ')') {
                orgStack.pop();
                helper.push('(');
                continue;
            }

            if (!helper.isEmpty() && curPop == helper.peek()) {
                orgStack.pop();
                helper.pop();
            } else {
                break;
            }
        }

        return orgStack.isEmpty();
    }
}
