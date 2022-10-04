package lambda4.itrable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//create a class employee
//add rec in list
//sort employee according to their name
// comparing using lambda
//lambda with iterable interface
public class Lambda4Itrable {
    public static void main(String[] args) {



        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);

//        Collections.sort(employees, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee employee1, Employee employee2) {
//                return employee1.getName().compareTo(employee2.getName());
//            }
//        });
        Collections.sort(employees,(employee1,employee2) -> employee1.getName().compareTo(employee2.getName()));

//        for(Employee employee : employees) {
//            System.out.println(employee.getName());
//        }
        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

//output
//Jack Hill
//40
//        John Doe
//        30
//        Snow White
//        22
//        Tim Buchalka
//        21
