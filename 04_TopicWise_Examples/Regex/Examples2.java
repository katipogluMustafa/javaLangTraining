import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

//        example1();
//        example2();
//        example3();
//        example4();
//        example5();
//        example6();
//        example7();
//        example8();
//        example9();
//        example10();
//        example11();
        example12();

    }

    private static void example12() {
        // Match 5-digit US zip code followed by dash and 4 digit extra digits
        String challenge  = "11111-1111";
        String challenge1 = "11111";
        System.out.println(challenge.matches("^\\d{5}(-\\d{4})?$"));
        System.out.println(challenge1.matches("^\\d{5}(-\\d{4})?$"));
    }

    private static void example11() {
        // Match 5-digit US zip code
        String challenge = "11111";

        Matcher matcher = Pattern.compile("^\\d{5}$").matcher(challenge);
        System.out.println(matcher.matches());
    }

    private static void example10() {
        // Extract what's in the curly braces
        String challenge = "{0,2}, {0,5}, {1,3}, {2,4}, {15,24}";

        Pattern pattern = Pattern.compile("\\{(\\d+),(\\d+)}");
        Matcher matcher = pattern.matcher(challenge);

        while( matcher.find() )
            System.out.println( "Found: " + matcher.group(1) + " - " + matcher.group(2));


    }

    private static void example9() {
        String challenge = "abcd.135\tevqz.7\ttzik.999\n";

        String regex = "[a-zA-Z]+\\.(\\d+)\\s";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(challenge);
        while( matcher.find() )
            System.out.println("Number Sequence: " + matcher.group(1) + " Indices [" + matcher.start(1)+ ":" + (matcher.end(1) - 1) + "]");
    }

    private static void example8() {
        String challenge = "abcd.135\tevqz.7\ttzik.999\n";

        String regex = "[a-zA-Z]+\\.(\\d+)\\s";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(challenge);
        while( matcher.find() )
            System.out.println("These Numbers Occured: " + matcher.group(1));
    }

    private static void example7() {
        String challenge = "abcd.135evqz.7tzik.999";

        String regex = "[a-zA-Z]+\\.([0-9]+)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(challenge);

        while( matcher.find() )
            System.out.println("These Numbers Occured: " + matcher.group(1));

    }

    private static void example6() {
        String challenge = "abcD.135";
        String regex = "^[a-zA-Z]+\\.[0-9]+$";
        String regexAlternative = "^[a-zA-Z]+\\.\\d+$";

        System.out.println(challenge.matches(regex));
        System.out.println(challenge.matches(regexAlternative));
    }

    private static void example5() {
        String challenge = "aaabccccccccdddefffg";

        // Exact match
        String regex = "^a{3}bc{8}d{3}ef{3}g$";
        System.out.println(challenge.matches(regex));

        // Alternatives
        System.out.println(challenge.matches("[a-g]*"));
        System.out.println(challenge.matches("[abcdefg]*"));

    }

    private static void example4() {
        String challenge = "Replace all blanks with underscores.";

        // Solution 1
        Pattern pattern = Pattern.compile(" ");
        Matcher matcher = pattern.matcher(challenge);
        System.out.println( matcher.replaceAll("_") );

        // Solution 2
        System.out.println( challenge.replaceAll(" ", "_"));

        // Solution 3, replace all whitespaces
        System.out.println( challenge.replaceAll("\\s", "_"));
    }

    private static void example3() {
        String strInput = "I gave $50 to my brother."
                + "He bought candy for $35. Now he has $15 left.";
        String strRegex = "\\$";
        String strReplacement = "£";
        String expectedOutput = "I gave £50 to my brother."
                + "He bought candy for £35. Now he has £15 left.";

        Pattern p = Pattern.compile(strRegex);
        Matcher m = p.matcher(strInput);
        System.out.println(m.replaceAll(strReplacement));
    }

    private static void example2() {
        String strIn = "foo|bar|hello|world";
        String regex = "|";
        String[] arr = strIn.split(Pattern.quote(regex));
        for (int i = 0; i < arr.length; i++)
            System.out.println("Element = "+ arr[i]);

        // the Pattern.quote() method is used to escape the given regex pattern and transform it into a String literal.
        // In other words, it escapes all the metacharacters present in the regex pattern for us. It is doing a similar job to \Q & \E.
    }

    private static void example1() {
        // When using '/' escape character in java regex
        // we know that the backslash character is an escape character in Java String literals as well.
        // Therefore, we need to double the backslash character when using it to precede any character (including the \ character itself).
        System.out.println("feof.".replaceAll("f\\.","f()"));
    }


}
