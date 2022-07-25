package cn.udslance.ilearningx;

import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @program: RoadToNice
 * @description: 给定一个设备编号区间[start, end]，包含4或18的编号都不能使用，如：418、148、718不能使用，108可用。
 * @author: Udslance
 * @create: 2022-07-14 17:25
 **/
public class ilearningx09 {

    public static void main(String[] args) {
        //Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        //int recordNum = Integer.valueOf(cin.nextLine());
        //List<String> records = new ArrayList<>(recordNum);
        //for (int i = 0; i < recordNum; i++) {
        //    records.add(cin.nextLine());
        //}
        //cin.close();

        List<String> records = new ArrayList<>();
        records.add("C 13300000000");
        records.add("W 13144444444");
        records.add("C 13144444444");
        records.add("C 03712832444");
        records.add("C 03712832233");
        records.add("W 03712832*");
        records.add("C 03712832444");
        String[][] results = getPhoneRecord(records);
        for (String[] result : results) {
            System.out.println(String.join(" ", Arrays.asList(result)));
        }
    }

    //终端产品的儿童电话手表有防骚扰特性，对电话呼入按如下规则处理：
    //
    //如果来电号码在白名单中，则电话要接通。
    //否则电话自动拒接。
    //现给定一组电话呼入和白名单操作的过程记录，格式为：
    //
    //C 13300000000 表示一条电话呼入记录。
    //W 13144444444 表示添加一个号码到白名单中；
    //W 03712832* 表示以 03712832 开头的号码都为白名单（*代表通配符，且仅在结尾）。
    //请按照给定的过程记录，分别统计每个呼入号码的接通和拒接次数：
    //
    //每个号码的统计记录的格式如：13144444444 1 3，以单个空格分隔，表示号码 13144444444 接通 1 次，拒接 3 次。
    //统计记录的输出顺序：按照给定记录中号码首次呼入出现的先后顺序。
    private static String[][] getPhoneRecord(List<String> records) {
        //先统计，再放入
        Map<String, int[]> tmp = new HashMap<>();
        //普通白名单
        Set<String> normalWL = new HashSet<>();
        //前缀白名单
        Set<String> preWL = new HashSet<>();
        //记录首次呼入
        List<String> order = new ArrayList<>();
        //遍历records
        for (String record : records) {
            //加入白名单
            if (record.startsWith("W")) {
                //加入前缀白名单
                if (record.endsWith("*")) {
                    //加入前缀白名单
                    String tmpPre = record.substring(2, record.length() - 1);
                    preWL.add(tmpPre);
                } else {
                    //加入普通白名单
                    String tmpPre = record.substring(2);
                    normalWL.add(tmpPre);
                }
            } else {
                String curNum = record.substring(2);
                if (!tmp.containsKey(curNum)) {
                    order.add(curNum);
                }
                //普通呼入
                //判断是否在普通白名单中
                boolean flag = true;
                if (normalWL.contains(curNum)) {
                    int[] tmpInt = tmp.getOrDefault(curNum, new int[2]);
                    tmpInt[0]++;
                    tmp.put(curNum, tmpInt);
                    flag = false;
                }
                if (flag) {
                    for (String s : preWL) {
                        if (curNum.startsWith(s)) {
                            int[] tmpInt = tmp.getOrDefault(curNum, new int[2]);
                            tmpInt[0]++;
                            tmp.put(curNum, tmpInt);
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag) {
                    int[] tmpInt = tmp.getOrDefault(curNum, new int[2]);
                    tmpInt[1]++;
                    tmp.put(curNum, tmpInt);
                }
            }
        }
        String[][] record = new String[tmp.size()][3];
        int i = 0;
        for (String s : order) {
            record[i][0] = s;
            record[i][1] = tmp.get(s)[0] + "";
            record[i][2] = tmp.get(s)[1] + "";
            i++;
        }
        return  record;
    }

}
