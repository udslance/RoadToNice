package cn.udslance.filter;

import java.util.List;

/**
 * @program: DesignPattern
 * @description:
 * @author: Udslance
 * @create: 2022-03-24 21:21
 **/
public interface Criteria {
    List<Person> meetCriteria(List<Person> persons);
}
