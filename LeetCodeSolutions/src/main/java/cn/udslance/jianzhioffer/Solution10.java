package cn.udslance.jianzhioffer;



/**
 * @author H
 * @create 2021-05-17 9:42
 */
public class Solution10 {

    
    public void test() {
        System.out.println(reverseWords("a good   example"));
    }


    public String reverseWords(String s) {
        // 删除首尾空格
        s = s.trim();
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while(i >= 0) {
            while(i >= 0 && s.charAt(i) != ' ') {
                // 搜索首个空格
                i--;
            }
            // 添加单词
            res.append(s.substring(i + 1, j + 1) + " ");
            while(i >= 0 && s.charAt(i) == ' ') {
                // 跳过单词间空格
                i--;
            }
            // j 指向下个单词的尾字符
            j = i;
        }
        // 转化为字符串并返回
        return res.toString().trim();
    }

}
