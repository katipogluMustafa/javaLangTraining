package com.meshale.PlayGround;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Person> l = Arrays.asList(
                new Person("Mustafa", "Katipoglu",20),
                new Person("Ahmet","K", 25),
                new Person("Yusuf Sertan", "G", 20),
                new Person("Abdullah", "E", 32)
        );

        // Method 1 for printing the list
        System.out.println("\nUsing classic For loop");
        for(int i = 0; i < l.size(); i++)
            System.out.println(l.get(i));

        // Method 2   : By Using For Each Loop
        System.out.println("\nUsing For-Each");
        for(Person p : l)
            System.out.println(p);

        // Method 3  : By Using Iterator
        System.out.println("\nUsing Iterator");
        Iterator<Person> p = l.iterator();
        while( p.hasNext() )
            System.out.println(p.next());

        // Method 4: By Using forEach Function with Lambda Expressions
        System.out.println("\nBy Using forEach Function with Lambda Expressions");
        l.forEach( person-> System.out.println(person) );

        // Method 5  : By Using Method Reference with the help of forEach function of List
        System.out.println("\nBy Using forEach Method with Method Reference Syntax");
        l.forEach( System.out::println );
        // Runs in parallel internally, doesn't care the order, just implements what you've said for each of the elements





    }



}

class Person{
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
