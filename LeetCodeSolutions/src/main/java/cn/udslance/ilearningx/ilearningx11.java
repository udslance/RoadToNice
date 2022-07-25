package cn.udslance.ilearningx;

import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @program: RoadToNice
 * @description: 给定一个设备编号区间[start, end]，包含4或18的编号都不能使用，如：418、148、718不能使用，108可用。
 * @author: Udslance
 * @create: 2022-07-14 17:25
 **/
public class ilearningx11 {

    static class DataFragment {
        int dataType;
        int index;
        int endFlag;
        int len;
        String data;

        DataFragment(int dataType, int index, int endFlag, int len, String data) {
            this.dataType = dataType;
            this.index = index;
            this.endFlag = endFlag;
            this.len = len;
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int dataFragmentCnt = cin.nextInt();
        DataFragment[] dataFragments = new DataFragment[dataFragmentCnt];
        for (int i = 0; i < dataFragmentCnt; i++) {
            int dataType = cin.nextInt();
            int index = cin.nextInt();
            int endFlag = cin.nextInt();
            int len = cin.nextInt();
            String data = cin.next();
            dataFragments[i] = new DataFragment(dataType, index, endFlag, len, data);
        }
        int dstType = cin.nextInt();
        cin.close();

        System.out.println(recombine(dataFragments, dstType));
    }

    //现给定一批接收到的数据分段和某一数据类型，请重组该数据类型的数据包，重组及输出的规则如下：
    //
    //成功重组必须是完整的数据：“分段序号”从0开始且是连续的，并且仅序号最大的数据分段的“结束标志”为1。
    //如果能成功重组，按“分段序号”升序，将该数据类型的“净荷内容”，拼接为一个字符串并输出。如果分段序号有重复则去重。
    //如果不能成功重组，则输出字符串NA。
    static String recombine(DataFragment[] dataFragments, int dstType) {
        //
        StringBuilder stringBuilder = new StringBuilder();
        Map<Integer, String> saver = new HashMap<>();
        //记录真实最大序号
        int realMax = 0;
        //记录结尾片段的最大序号
        int endIndex = 0;

        // 遍历dataFragments
        for (DataFragment dataFragment : dataFragments) {
            // 首先判断是否是需要的数据类型
            if (dataFragment.dataType == dstType) {
                //实时更新最大序号
                realMax = Math.max(realMax, dataFragment.index);
                //实时查找结尾片段的序号
                if (dataFragment.endFlag == 1) {
                    endIndex = dataFragment.index;
                }
                //将目标数据放入存储器中待重组，同时去重
                saver.put(dataFragment.index, dataFragment.data);
            }
        }
        // 如果序号最大的数据分段的“结束标志”为1
        if (endIndex != realMax || saver.size() == 0) {
            return "NA";
        }

        for (int i = 0; i < saver.size(); i++) {
            //如果不连续，则输出"NA"
            if (!saver.containsKey(i)) {
                return "NA";
            }
            String curStr = saver.get(i);
            stringBuilder.append(curStr);
        }

        return stringBuilder.toString();
    }

}
