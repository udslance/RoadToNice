package cn.udslance.leetcode.startswith4;



/**
 * @author H
 * @create 2021-08-23 9:21
 */
public class Solution443 {
    
    public void test() {
        System.out.println(compress(new char[]{'a','a','b','b','c','c','c'}));
    }

    /**
     * 压缩字符串
     * @param chars
     * @return
     */
    public int compress(char[] chars) {
        //用左右指针维护一个滑动窗口，该窗口中只允许存在一种字符
        int left = 0, right = 1, size, mod = 0;
        char cur = chars[left];

        for (; right < chars.length; right++) {
            if (chars[right] == cur) {
                continue;
            }

            if (chars[right] != cur) {
                //右指针遇到了不同的字符
                mod = getMod(chars, left, right, mod, cur);
                left = right;
                cur = chars[left];
            }
        }

        mod = getMod(chars, left, right, mod, cur);

        return mod;
    }

    private int getMod(char[] chars, int left, int right, int mod, char cur) {
        int size;
        size = right - left;
        chars[mod++] = cur;
        if (size != 1) {
            String tmp = String.valueOf(size);
            for (char c : tmp.toCharArray()) {
                chars[mod++] = c;
            }
        }
        return mod;
    }
}
