package cn.udslance.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: DesignPattern
 * @description:
 * @author: Udslance
 * @create: 2022-03-24 21:23
 **/
public class CriteriaSingle implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> singlePersons = new ArrayList<Person>();
        for (Person person : persons) {
            if(person.getMaritalStatus().equalsIgnoreCase("SINGLE")){
                singlePersons.add(person);
            }
        }
        return singlePersons;
    }
}
