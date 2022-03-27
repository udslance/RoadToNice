package cn.udslance.leetcode.mainofleetcode0;



import java.util.ArrayList;
import java.util.List;

/**
 * @author H
 * @create 2021-07-17 22:43
 */
public class Solution093 {
    
    public void test() {
        List<String> list = restoreIpAddresses("101023");

        System.out.println(list);
    }


    public List<String> restoreIpAddresses(String s) {
        //用于存放有效路径
        List<List<String>> paths = new ArrayList<>();

        //用于存放有效节点
        List<String> nodes = new ArrayList<>();

        //递归
        dfs(0, s, nodes, paths);
        List<String> res = new ArrayList<>();
        //将节点集连成路径
        for (List<String> re : paths) {
            res.add(helper(re));
        }
        return res;
    }

    /**
     * @param start 递归起始点
     * @param s 原字符串
     * @param nodes 用于存放有效节点
     * @param paths 用于存放有效路径
     */
    private void dfs(int start, String s, List<String> nodes, List<List<String>> paths) {
        //终止条件
        //1. 节点集已满
        //2. 已遍历到末尾
        if (nodes.size() == 4 && start == s.length()) {
            paths.add(new ArrayList<>(nodes));
            return;
        }
        //节点集已满但没有遍历到末尾
        if (nodes.size() == 4) {
            return;
        }
        for (int i = start + 1; i <= start + 5; i++) {
            if (i > s.length()) {
                break;
            }
            String tmpStr = s.substring(start, i);
            int tmpInt = Integer.parseInt(tmpStr);
            //检查tmp是否有加入的资格
            //1. 不能有前导0
            //2. 不能大于255
            //3. 不能超过3位
            if ((tmpStr.length() > 1 && tmpStr.startsWith("0")) || tmpInt > 255 || tmpStr.length() > 3) {
                break;
            }
            //加入结点集
            nodes.add(tmpStr);
            //递归
            dfs(i, s, nodes, paths);
            //回溯
            nodes.remove(nodes.size() - 1);
        }
    }

    /**
     * 用于将结点集中的节点连成路径
     * @param nodes
     * @return
     */
    private String helper(List<String> nodes) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            stringBuilder.append(nodes.get(i)).append(".");
        }
        stringBuilder.append(nodes.get(3));

        return stringBuilder.toString();
    }
}
