package com.meshale.PlayGround;

public class Main {
    public static void main(String[] args) {
        int a = 20;
        int b = 30;
        // You can use effectively final or final variables inside lambda expression
        doProcess(a, i-> System.out.println(i + b));


    }

    public static void doProcess(int i , Processor p){
        p.process(i);
    }

    interface Processor{
        void process(int i);
    }
}
