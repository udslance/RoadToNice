package cn.udslance.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: DesignPattern
 * @description:
 * @author: Udslance
 * @create: 2022-03-24 21:22
 **/
public class CriteriaFemale implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> femalePersons = new ArrayList<>();
        for (Person person : persons) {
            if("FEMALE".equalsIgnoreCase(person.getGender())){
                femalePersons.add(person);
            }
        }
        return femalePersons;
    }
}
