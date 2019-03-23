package com.meshale.PlayGround;

public class Person implements Cloneable{
    private String firstName;
    private String lastName;
    private int age;

    @Override
    public Person clone() throws CloneNotSupportedException{
        Person cloned = (Person) super.clone();
        return cloned;
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
