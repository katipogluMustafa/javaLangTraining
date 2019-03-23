package com.meshale.PlayGround;


public class Main{
    public static void main(String[] args) throws CloneNotSupportedException{
        Person mother = new Person("Mot", "her", 45);
        Person father = new Person("fat", "her", 50);
        Student newStudent = new Student("St", "Ude", 15, "New High School", mother, father);

        Student referenceCopy = newStudent;
        newStudent.setMother(new Person("This shouldn't have changed original one", "!!",-1));
        System.out.println("Reference Copy: ");
        referenceCopy.greet();
        System.out.println();

        Student cloneStudent = newStudent.clone();
        cloneStudent.setFather(null);
        cloneStudent.setMother(null);
        cloneStudent.greet();
        newStudent.greet();
        // As you can see, cloneStudent is deep copy of newStudent object.

        // Be careful to implement clone for fields that are mutable since they need to be cloned too to make a deep copy.



    }



}

