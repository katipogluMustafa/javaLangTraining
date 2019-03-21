package com.meshale.PlayGround;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Main {
    private String name;
    private Comparator<Main> comparator;

    public Main(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        caller("Mustafa", "M", ( str, prefix) -> str.startsWith(prefix)   );
        // Lambda expression can be replaced by method reference
        caller("Ahmet", "A", String::startsWith);
        caller("Yusuf", "P", String::startsWith);

        Main main = new Main("First");
        main.setComparator((m1,m2)-> m1.getName().compareTo(m2.getName()));
        main.setComparator(Comparator.comparing(Main::getName));

        List<Main> list = new ArrayList<>();
        list.add(new Main("Second"));
        list.add(new Main("Third"));
        list.add(main);

        printer(list, System.out::println);

    }

    public static void caller(String str, String prefix, BiFunction<String, String, Boolean> function){
        if( function.apply(str, prefix) )
            System.out.println(str);
    }

    public static void printer(List<Main> l , Consumer<Main> printAction){
        for(Main m : l)
            printAction.accept(m);
    }

    public void setComparator(Comparator<Main> c){
        this.comparator = c;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Main{" +
                "name='" + name +
                '}';
    }
}
