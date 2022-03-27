package cn.udslance.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: DesignPattern
 * @description:
 * @author: Udslance
 * @create: 2022-03-24 21:22
 **/
public class CriteriaMale implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> malePersons = new ArrayList<>();
        for (Person person : persons) {
            if("MALE".equalsIgnoreCase(person.getGender())){
                malePersons.add(person);
            }
        }
        return malePersons;
    }
}
