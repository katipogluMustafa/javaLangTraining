package com.meshale.JavaLangTraining;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee implements Cloneable {
    private String name;
    private double salary;
    private Date hireDay;

    public Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
        hireDay = new Date();
    }

    @Override
    public Employee clone() throws CloneNotSupportedException{
        Employee cloned = (Employee)super.clone();
        cloned.hireDay = (Date)hireDay.clone();             // Clone the mutable fields
        return cloned;
    }

    public void setHireDay(int year, int month, int day){
        Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();
        hireDay.setTime( newHireDay.getTime() );
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", hireDay=" + hireDay +
                '}';
    }

    public static void main(String... args) throws CloneNotSupportedException{
        Employee original = new Employee("Ahmet", 185000);
        original.setHireDay(2015,15,15);
        Employee clone = (Employee)original.clone();
        clone.setHireDay(2017,11,2);
        System.out.println("Original: " + original);
        System.out.println("Cloned: " + clone);
    }

}
