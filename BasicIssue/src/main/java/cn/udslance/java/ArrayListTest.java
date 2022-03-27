package cn.udslance.java;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ArrayListTest {
    @Test
    public void test01() {
        String[] strings = {"1", "2"};
        List<String> arrayList = Arrays.asList(strings);
        //UnsupportedOperationException
        arrayList.add("3");

        System.out.println(arrayList);
    }

    @Test
    public void test02(){
        String[] strings = {"1", "2"};
        List<String> list = Lists.newArrayList(strings);

        String[] strings1 = Arrays.copyOf(strings,2);

        list.add("3");

        System.out.println(list);
    }
}
