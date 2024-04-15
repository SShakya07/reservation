package StreamApi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Employee
{

    private String name;
    private int salary;


    public Employee(String name, int salary) {
        this.name= name;
        this.salary= salary;
    }

    public String getName() {
        return name;
    }
    public int getSalary() {
        return salary;
    }

    public String toString() {
        return "Employee: "+ name;
    }
    public static void main(String[] args) {
        List<Employee> empl= new ArrayList<>();
        empl.add(new Employee("n1",90000));
        empl.add(new Employee("n2",60000));
        empl.add(new Employee("n3", 70000));

        empl.sort(Comparator.comparingInt(Employee::getSalary));
        empl.forEach(System.out::println);




    }

}