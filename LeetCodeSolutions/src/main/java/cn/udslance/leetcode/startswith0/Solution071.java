package cn.udslance.leetcode.startswith0;



import java.util.ArrayList;
import java.util.List;

/**
 * @author H
 * @create 2021-07-15 15:52
 */
public class Solution071 {
    /**
     * 给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
     *
     * 在 Unix 风格的文件系统中：
     * 1. 一个点（.）表示当前目录本身；
     * 2. 两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。
     * 3. 任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/'
     * 4. 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。
     * 请注意，返回的 规范路径 必须遵循下述格式：
     *
     * 1. 始终以斜杠 '/' 开头。
     * 2. 两个目录名之间必须只有一个斜杠 '/' 。
     * 3. 最后一个目录名（如果存在）不能 以 '/' 结尾。
     * 4. 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        List<String> helper = new ArrayList<>();

        //提取路径中非“/”的部分，加入到 helper 中
        for (int i = 0; i < path.length();) {
            while (i < path.length() && path.charAt(i) == '/') {
                i++;
            }
            int j = i;
            while (j < path.length() && path.charAt(j) != '/' ) {
                j++;
            }

            if (i != j) {
                helper.add(path.substring(i, j));
            }

            i = j + 1;

        }

        //遍历 helper
        // “.”：无意义路径点，删除
        // “..”：返回上级，将本级连同上级一起删除
        for (int i = 0; i < helper.size();) {
            if (".".equals(helper.get(i))) {
                helper.remove(i);
            } else if ("..".equals(helper.get(i))) {
                helper.remove(i);
                if (i > 0) {
                    helper.remove(i - 1);
                }
                i = i == 0 ? 0 : i - 1;
            } else {
                i++;
            }
        }

        //如果 helper 当中已没有留下路径，则直接返回根路径
        if (helper.size() == 0) {
            return "/";
        }

        //使用 StringBuilder 来组合结果路径
        StringBuilder stringBuilder = new StringBuilder();

        for (String s : helper) {
            stringBuilder.append("/");
            stringBuilder.append(s);

        }

        return stringBuilder.toString();
    }

    
    public void test() {
        String str = simplifyPath("/a/../../b/../c//.//");


        System.out.println(str);
    }
}
