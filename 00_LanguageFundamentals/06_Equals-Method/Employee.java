package com.meshale.JavaLangTraining;

import java.time.LocalDate;
import java.util.Objects;

public class Employee extends Person{
    private double salary;
    private LocalDate hireDay;
    private static int nextId = 0;
    int id;

    public Employee(String name, double salary, int year, int month, int day){
        super(name);
        this.salary = salary;
        this.hireDay = LocalDate.of(year,month,day);
        this.id = setId();
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public String getDescription(){
        return String.format("an employee with a salary %.2f", salary);
    }

    public void raiseSalary(double byPercent){
        double raise = salary * byPercent /100;
        salary += raise;
    }

    private int setId(){
        return nextId++;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object other){
        if( this == other)                    // if both points to the same memory then they are equal
            return true;
        if( other == null)                   //  Part of the requirements for the equal method, if someone compare anything with null,
            return false;                    // you're not allowed to throw an exception but you need to return false.
        if( getClass() != other.getClass() ) // if they are not in the same class, it is false
            return false;

        Employee oth = (Employee)other;

        // We don't use normal equals methods since if objects are null, we can use any method on them so we need to be sure in this case name and hireDay is not null
        // Objects.equals method checks if any of them null returns false otherwise it calls normal equals method for us.
        return Objects.equals( getName(), oth.getName() ) && getSalary() == oth.getSalary() && Objects.equals(getHireDay(), oth.getHireDay());
    }

    public static Integer getNextId(){
        return nextId;
    }


}
