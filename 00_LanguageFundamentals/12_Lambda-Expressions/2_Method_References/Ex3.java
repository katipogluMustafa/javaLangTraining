package com.meshale.PlayGround;


import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
       Thread t = new Thread(Main::printer);                        // Call printer function
       Thread anotherThread = new Thread(System.out::println);      // print a line

        Main m = new Main();
        m.printWithAction("Mustafa", System.out::print);
        m.printWithAction(" Ahmet", System.out::println);

    }

    public static void printer(){
        System.out.println("Printing from printer");
    }

    public void printWithAction(String s, Consumer<String> printAction){
        printAction.accept(s);
    }
}