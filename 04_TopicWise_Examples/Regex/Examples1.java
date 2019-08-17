import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        example1();
        example2();
        example3();
        example4();
        example5();

    }

    private static void example5() {
        System.out.println("\nExample 5");

        String str = "tvtktvtkt";
        String ptr = "t(?=v)";      // Look for all matches of the t followed by v but we don't include v inside the result
        Pattern pattern = Pattern.compile(ptr);
        Matcher matcher = pattern.matcher(str);
        int count = 0;
        while ( matcher.find() )
            System.out.println("Occurrence " + count++ + " : " + matcher.start() + " - " + matcher.end());
    }

    private static void example4() {
        System.out.println("\nExample 4");

        String str = "tvtktvtkt";
        String ptr = "t(?!v)";      // (? is for look ahead
        // Look ahead does not include the characters that matched in the text
        // see from output, results  1 character
        Pattern pattern = Pattern.compile(ptr);
        Matcher matcher = pattern.matcher(str);
        int count = 0;
        while ( matcher.find() )
            System.out.println("Occurrence " + count++ + " : " + matcher.start() + " - " + matcher.end());
    }

    private static void example3() {
        System.out.println("\nExample 3");

        String str = "tvtktvtkt";
        String ptr = "t[^v]";
        Pattern pattern = Pattern.compile(ptr);
        Matcher matcher = pattern.matcher(str);
        int count = 0;
        while ( matcher.find() )
            System.out.println("Occurrence " + count++ + " : " + matcher.start() + " - " + matcher.end());

        // Be careful, it couldn't find the last one that there exists t but doesn't followed by any character
        // this is because the pattern [^v] says that it must be followed by a character but not v
        // see example4
    }


    private static void example2() {
        String str = "Mert Oz";
        System.out.println(str.replaceAll("[^ ]", "x"));
    }

    private static void example1() {
        String str = "Mustafa Katipoglu";
        System.out.println(str.replaceAll("[Mm]ustafa", "Savci"));
        System.out.println(str.replaceAll("[M|m]ustafa", "Savci"));
        System.out.println(str.replaceAll("(M|m)ustafa", "Savci"));
    }

}
