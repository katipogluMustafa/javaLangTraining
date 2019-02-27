package com.meshale.JavaLangTraining;

public class Manager extends Employee {
    double bonus;

    public Manager(String name, double salary, int year, int month, int day, double bonus){
        super(name,salary,year,month,day);
        this.bonus = bonus;
    }

    @Override
    public boolean equals(Object other){
        if( !super.equals(other) )
            return false;

        Manager temp = (Manager)other;
        return getBonus() == temp.getBonus();
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus){
        this.bonus = bonus;
    }

}
