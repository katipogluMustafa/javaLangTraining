package com.meshale.JavaLangTraining;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class Employee implements Comparable<Employee>{
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        hireDay = LocalDate.of(year,month,day);
    }

    public String getName(){
        return this.name;
    }

    public double getSalary(){
        return this.salary;
    }

    public LocalDate getHireDay(){
        return this.hireDay;
    }

    public void raiseSalary(double byPercent){
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    @Override
    public boolean equals(Object otherObject){
        if(this == otherObject) return true;
        if(otherObject == null) return false;
        if(getClass() != otherObject.getClass() ) return false;

        Employee other = (Employee)otherObject;
        return Objects.equals(name, other.getName()) && salary == other.getSalary() && Objects.equals(hireDay, other.getHireDay());
    }

    @Override
    public int hashCode(){
        return Objects.hash(name,salary, hireDay);
    }

    @Override
    public String toString(){
        return getClass().getName() + "[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay + "]";
    }

    @Override
    public int compareTo(Employee e){
        return Double.compare(this.salary, e.getSalary());
    }

    public static void main(String... args){

        Employee[] employees = new Employee[3];
        employees[0] = new Employee("Ahmet", 150000, 2015,12,7);
        employees[1] = new Employee("Mehmet", 180000, 2012,5,1);
        employees[2] = new Employee("Yusuf", 100000, 2018,7,15);

        Arrays.sort(employees);
        for(Employee e: employees)
            System.out.println(e);
    }

}
