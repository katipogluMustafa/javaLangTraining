package com.meshale.Control;

public class Main {

    public static void main(String... args) {
        System.out.println(max(5,6,8,1,2,3,232,55,6,66,1,0));
    }

    public static double max(double... values){
        double largest = Double.NEGATIVE_INFINITY;
        for(double v : values)
            if(v > largest)
                largest = v;
        return largest;
    }
}