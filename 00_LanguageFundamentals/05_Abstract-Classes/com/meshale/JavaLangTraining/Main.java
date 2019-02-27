package com.meshale.JavaLangTraining;

public class Main {

    public static void main(String[] args) {

        Person[] people = new Person[2];

        people[0] = new Employee("Ahmet K",50000,1989,10,1);
        people[1] = new Student("Mustafa K","Computer Engineering");

        for(Person p : people)
            System.out.println( p.getName() + " " +  p.getDescription());

        
    }

}
