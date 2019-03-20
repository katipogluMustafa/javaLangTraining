package com.meshale.PlayGround;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Person {
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
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Mustafa", "K",20),
                new Person("Ahmet", "K",20),
                new Person("Yusuf", "G",20),
                new Person("Mert", "O",20),
                new Person("Kaan", "Y",20),
                new Person("Muhammed", "S",20)
        );

        people.sort( (a,b)-> a.getLastName().compareTo(b.getLastName()) );
        for( Person p : people)
            System.out.println(p);

        Finder f = (l,s)->{
            List<Person> ret = new ArrayList<>();
            for(Person p : l)
                if(p.getLastName().startsWith(s))
                    ret.add(p);
            return ret;
        };

        System.out.println("\nStarting With K\n");
        List<Person> startsWithK = f.find(people, "K");
        for (Person p : startsWithK)
            System.out.println(p);
    }

    interface Finder{
        public List<Person> find(List<Person> l, String s);
    }

}
