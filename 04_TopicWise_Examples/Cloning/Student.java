package com.meshale.PlayGround;

public class Student extends Person implements Cloneable{
    String schoolName;
    Person mother;
    Person father;

    @Override
    public Student clone() throws CloneNotSupportedException{
        Student cloned = (Student)super.clone();
        cloned.mother = mother.clone();
        cloned.father = father.clone();
        return cloned;
    }

    public Student(String name, String lastName, int age, String schoolName){
        super(name,lastName,age);
        this.schoolName = schoolName;
        this.mother = null;
        this.father = null;
    }

    public Student(String firstName, String lastName, int age, String schoolName, Person mother, Person father) {
        super(firstName, lastName, age);
        this.schoolName = schoolName;
        this.mother = mother;
        this.father = father;
    }

    @Override
    public void greet() {
        super.greet();
    }

    @Override
    public String toString() {
        return "Student{" +
                "schoolName='" + schoolName + '\'' +
                ", mother=" + mother +
                ", father=" + father +
                '}';
    }

    public String getSchoolName() {
        return schoolName;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    @Override
    public boolean equals(Object obj){
        if(!super.equals(obj))
            return false;
        Student p = (Student)obj;
        return  this.getSchoolName().equals(p.getSchoolName()) && this.getFather().equals(p.getFather()) && this.getMother().equals(p.getMother());
    }

}
