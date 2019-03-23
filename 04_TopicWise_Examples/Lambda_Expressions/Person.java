package com.meshale.JavaLangTraining;

import java.util.*;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Person[] people = Person.randomPersonFactory(10);
        Arrays.sort(people, (p1,p2)->p1.getFirstName().compareTo(p2.getFirstName()));       // Classic Lambda Expression

        List<Person> list = new ArrayList<>( Arrays.asList(people) );
        list.forEach(System.out::println);                   // Method Reference

        System.out.println();

        List<Person> anotherList = new LinkedList<>(Arrays.asList(people));
        Comparator<Person> comperator = (p1,p2)-> p1.getFirstName().compareTo(p2.getFirstName());
        anotherList.sort(comperator);
        anotherList.forEach(System.out::println);

        anotherList.add(null);
        anotherList.add(null);
        Predicate<Person> checkNull = p->p==null;
        anotherList.removeIf(checkNull);
        anotherList.forEach(System.out::println);

        Factory<Person> factoryMethod = Person::new;
        Person p = factoryMethod.factory();

        PersonFactory personFactory = Person::new;
        Person a = personFactory.factory("Mustafa", "Katipoglu",20);
        a.greet();

        List<String> names = new ArrayList<>(Arrays.asList("Mustafa","Ahmet","Yusuf","Mehmet","Space"));
        Stream<Person> personStream = names.stream().map(Person::new);
        List<Person> listt = personStream.collect(Collectors.toList());
        listt.forEach( System.out::println);

        repeat(5, ()-> System.out.println("Did you miss me ?"));
        count(10, j->System.out.printf("I see number %d \n",j));
        int n = 10;
        count(n, j-> System.out.println("Counting down:" + (n-j) ));

        // Comparator Lambda Specific Methods
        Arrays.sort(people, Comparator.comparing(Person::getLastName));
        Arrays.sort(people, Comparator.comparingInt(Person::getAge));       // Less steps if you use comparingInt etc. for primitive types
        // Arrays.sort(words, Comparator.comparingInt(String::length) );

        // Chained Comparing
        Arrays.sort(people, Comparator.comparing(Person::getFirstName).thenComparing(Person::getLastName).thenComparingInt(Person::getAge));
    }

    public static void repeat(int n, Runnable action){
        for(int i = 0; i < n; i++)
            action.run();
    }

    public static void count(int n, IntConsumer consumer){
        for (int i = 0; i < n; i++)
            consumer.accept(i);
    }

    @FunctionalInterface
    interface Factory<T>{
        T factory();
    }

    @FunctionalInterface
    interface PersonFactory{
        Person factory(String name, String lastName, int age);
    }


}

class Person implements Cloneable{
    private String firstName;
    private String lastName;
    private int age;

    @Override
    public Person clone() throws CloneNotSupportedException{
        Person cloned = (Person) super.clone();
        return cloned;
    }

    public Person(){
        this.firstName = null;
        this.lastName = null;
        this.age = -1;
    }

    public Person(String firstName) {
        this.firstName = firstName;
        this.lastName = null;
        this.age = -1;
    }

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

    public void greet(){
        System.out.println(this);
    }

    public static Person[] randomPersonFactory(int n){
        Random rand = new Random();
        int random;

        Person[] people = new Person[n];
        for(int i = 0; i < n; i++){
            StringBuilder s = new StringBuilder();
            random = rand.nextInt(256);
            for(int j = 0; j < Math.sqrt(random); j++){
                s.insert(j,rand.nextInt(128));
            }
            people[i] = new Person(s.toString());
        }

        return people;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if( this == obj )
            return true;

        if( obj == null)
            return false;

        if(this.getClass() != obj.getClass())
            return false;

        Person other = (Person)obj;

        return this.getFirstName().equals(other.getFirstName()) && this.getLastName().equals(other.getLastName()) && this.getAge()==other.getAge();
    }
}
