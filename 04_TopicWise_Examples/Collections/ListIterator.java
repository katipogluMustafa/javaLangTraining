import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Test {
    public static void main(String[] args) {
        List<String> names = new LinkedList<>(Arrays.asList("Mustafa","Ahmet","Yusuf","Mert","Ugur","Asaf"));
        ListIterator<String> listIterator;

        // Start to end traversal with Lambda Expression
        System.out.println("By Using Method Reference: ");
        listIterator = names.listIterator();
        listIterator.forEachRemaining(System.out::println);

        // Start to and traversal
        System.out.println("By Using hasNext and next methods: ");
        listIterator = names.listIterator();
        while( listIterator.hasNext() )
            System.out.println(listIterator.next());

        // From end to start traversal
        System.out.println("By Using hasPrevious and previous methods: ");
        listIterator = names.listIterator( names.size() );
        while( listIterator.hasPrevious() )
            System.out.println(listIterator.previous());
    }
}
