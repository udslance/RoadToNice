package cn.udslance.interview.huawei;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author H
 * @create 2021-08-23 9:21
 */
class Solution001 {
    //输入字符串， 若干单词
    //找字符串子串刚好把这些单词用完，所有单词都用一遍，顺序没有要求，但不能包括无关单词
    //1. 单词长度都相同
    public void solution001(String str, List<String> inputList) {
        String[] inputStrs = str.trim().split( " ");
        Set<String> wordSet = new HashSet<>(inputList);
        List<String> outWords = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        //定义左右指针
        int l = 0, r = 0;

        for (; r < inputStrs.length; r++) {
            String tmp = inputStrs[r];
            //如果单词列表中包含当前单词，应从列表中剔除
            if (wordSet.contains(tmp)) {
                wordSet.remove(tmp);
                outWords.add(tmp);
            } else {
                //如果单词列表中不包含该单词，则 l重置
                l = r + 1;
                //之前被淘汰的单词也应重新回到set中
                wordSet.addAll(outWords);
                outWords.clear();
            }

            if (wordSet.isEmpty()) {
                //从l到r，是符合要求的子串，进行拼接
                for (int i = l; i < r + 1; i++) {
                    stringBuilder.append(inputStrs[i]).append(" ");
                }
                System.out.println(stringBuilder.toString().trim());
                stringBuilder = new StringBuilder();
                l++;
                wordSet.add(outWords.remove(0));
            }
        }
    }



    
    public void test() {
        long startTime = System.currentTimeMillis();
        //do something
        String str = "a b c d a b e";
        List<String> inputList = new ArrayList<>();
        inputList.add("a");
        inputList.add("b");
        inputList.add("c");
        inputList.add("d");

        solution001(str,inputList);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
}
