package com.meshale.JavaLangTraining;

import java.util.Arrays;
import java.util.Comparator;


public class Employee implements Cloneable {
    private String name;

    public Employee(String name){
        this.name = name;
    }

    public static void main(String... args){

        Employee arr[] = new Employee[5];
        arr[0] = new Employee("Ahmet");
        arr[1] = new Employee("Mehmet");
        arr[2] = new Employee("Yusuf");
        arr[3] = new Employee("Muhammed");
        arr[4] = new Employee("Mustafa");
        Arrays.sort(arr, new EmployeeComparator() );
        for(Employee e : arr)
            System.out.println(e.name);
    }

    public String getName() {
        return name;
    }


}

class EmployeeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee first, Employee second){
        return first.getName().compareTo(second.getName() );
    }
}
