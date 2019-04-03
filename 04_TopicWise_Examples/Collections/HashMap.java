import java.util.*;
import java.util.function.BiConsumer;

public class Main {
    public static int nextId = 0;
    public static void main(String[] args) {

        Map<Integer, String> people = new HashMap<>();
        people.put(nextId++, "Mustafa");
        people.put(nextId++, "Ahmet");
        people.put(nextId++, "Yusuf");
        people.put(nextId++, "Mert");
        people.put(nextId++, "Mahmut");

        // Lets Iterate over HashMap

        // Method 1
        for(Map.Entry<Integer, String> entry : people.entrySet() ){
            Integer e = entry.getKey();
            String ss = entry.getValue();
            System.out.printf("%d - %s\n", e, ss);
        }

        // Method 2
        people.forEach( (k,v)-> System.out.printf("%d - %s\n",k,v) );

        // Method 3
        for(Integer i : people.keySet() )
            System.out.printf("%d - %s", i, people.get(i));


    }

}

