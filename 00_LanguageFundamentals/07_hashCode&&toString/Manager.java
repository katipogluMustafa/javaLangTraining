package com.meshale.JavaLangTraining;

public class Manager extends Employee {
    private double bonus;
    public Manager(String name, double salary,int year, int month, int day){
        super(name,salary,year,month,day);
        bonus = 0;
    }

    public double getBonus(){
        return this.bonus;
    }

    public void setBonus(double bonus){
        this.bonus = bonus;
    }

    @Override
    public double getSalary(){
        return super.getSalary() + bonus;
    }


    @Override
    public boolean equals(Object otherObject) {
        if( !super.equals(otherObject)) return false;
        Manager other = (Manager)otherObject;
        return bonus == other.getBonus();
    }

    @Override
    public int hashCode(){
        return java.util.Objects.hash(super.hashCode(), bonus);
    }

    @Override
    public String toString(){
        return super.toString() + "[bonus=" + bonus +"]";
    }

}
