package cn.udslance.filter;

import java.util.List;

/**
 * @program: DesignPattern
 * @description:
 * @author: Udslance
 * @create: 2022-03-27 10:37
 **/
public class AndCriteria implements Criteria {

    private Criteria criteria;
    private Criteria otherCriteria;

    public AndCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons) {

        List<Person> firstCriteriaPersons = criteria.meetCriteria(persons);
        //取交集
        return otherCriteria.meetCriteria(firstCriteriaPersons);
    }
}
