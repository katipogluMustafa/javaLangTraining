package com.meshale.PlayGround;


import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        caller("Mustafa", "M", ( str, prefix) -> str.startsWith(prefix)   );
        // Lambda expression can be replaced by method reference
        caller("Ahmet", "A", String::startsWith);
        caller("Yusuf", "P", String::startsWith);

    }

    public static void caller(String str, String prefix, BiFunction<String, String, Boolean> function){
        if( function.apply(str, prefix) )
            System.out.println(str);
    }
}