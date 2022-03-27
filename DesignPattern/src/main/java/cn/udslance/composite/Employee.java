package cn.udslance.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: DesignPattern
 * @description: 使用 Employee 类来创建和打印员工的层次结构。
 * @author: Udslance
 * @create: 2022-03-27 10:56
 **/
public class Employee {
    private String name;
    private String dept;
    private int salary;
    private List<Employee> subordinates;

    /**
     * 构造函数
     * @param name
     * @param dept
     * @param sal
     */
    public Employee(String name,String dept, int sal) {
        this.name = name;
        this.dept = dept;
        this.salary = sal;
        subordinates = new ArrayList<Employee>();
    }

    public void add(Employee e) {
        subordinates.add(e);
    }

    public void remove(Employee e) {
        subordinates.remove(e);
    }

    public List<Employee> getSubordinates(){
        return subordinates;
    }

    @Override
    public String toString(){
        return ("Employee :[ Name : "+ name
                +", dept : "+ dept + ", salary :"
                + salary+" ]");
    }
}
