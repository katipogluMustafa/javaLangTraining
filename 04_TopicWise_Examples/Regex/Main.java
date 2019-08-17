import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        //example1();
        //example2();
        //example3();
        //example4();
        //example5();
        //example6();
        //example7();
        //example8();
        //example9();
        //example10();
        example11();

    }

    private static void example11() {
        String text = "Must afa katip oglu";
        String patternString = " ";
        String[] anotherSplit = Pattern.compile(patternString).split(text);
        for (int i = 0; i < anotherSplit.length; i++)
            System.out.println("element = " + anotherSplit[i]);
    }

    private static void example10() {
        String text = "Must:afa:katip:oglu";
        String patternString = ":";
        String[] anotherSplit = Pattern.compile(patternString).split(text);
        for (int i = 0; i < anotherSplit.length; i++)
            System.out.println("element = " + anotherSplit[i]);
    }

    private static void example9() {
        String text = "A sep Text sep With sep Many sep Separators";

        String patternStr = "sep";
        Pattern pattern = Pattern.compile(patternStr);
        String[] split = pattern.split(text);
        for (int i = 0; i < split.length; i++)
            System.out.println("element = " + split[i] );

    }

    private static void example8() {
        String text    =
                "John writes about this, and John Doe writes about that," +
                        " and John Wayne writes about everything.";

        String patternString1 = "((John) (.+?)) ";

        Pattern pattern = Pattern.compile(patternString1);
        Matcher matcher = pattern.matcher(text);

        StringBuffer stringBuffer = new StringBuffer();

        while(matcher.find()){
            matcher.appendReplacement(stringBuffer, "Joe Blocks ");
            System.out.println(stringBuffer.toString());
        }
        matcher.appendTail(stringBuffer);

        System.out.println(stringBuffer.toString());

        // with appendReplacement method only the characters starting from then end of the last match, and until just before the matched characters are copied.
    }

    /* replaceAll replaceFirst */
    private static void example7() {
        String text = "John writes about this, and John Doe writes about that," +
                " and John Wayne writes about everything.";
        String patternStr = "((John) (.+?)) ";
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(text);

        String replaceAll = matcher.replaceAll("Joe Blocks ");
        System.out.println( "replaceAll : " + replaceAll);

        //matcher.reset();
        String replaceFirst = matcher.replaceFirst("Joe Blocks ");
        System.out.println("replaceFirst : " + replaceFirst);
    }

    /* Groups Inside Groups 2 */
    private static void example6() {
        String text    =
                "John writes about this , and John Doe writes about that," +
                        " and John Wayne writes about everything.";

        String patternStr = "((John) (.+?))((.+?) (and) (.+?))";
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(text);

        while( matcher.find() )
            System.out.println( "found: <" + matcher.group(1) +
                    "> <"      + matcher.group(2) +
                    "> <"      + matcher.group(3) +
                    "> <"      + matcher.group(4) +
                    "> <"      + matcher.group(5) +
                    "> <"      + matcher.group(6) +
                    "> <"      + matcher.group(7) + ">" );

    }

    /* Groups Inside Groups */
    private static void example5() {
        String text    =
                "John writes about this, and John Doe writes about that," +
                        " and John Wayne writes about everything.";

        String patternStr = "((John) (.+?))";
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(text);

        while( matcher.find() )
            System.out.println( "found: <" + matcher.group(1) +
                                "> <"      + matcher.group(2) +
                                "> <"      + matcher.group(3) + ">" );

    }

    /* Multiple Groups */
    private static void example4() {
        String text    =
                "John writes about this, and John reads about that," +
                        " and John writes about everything. John does not like to write";
        String patternStr = "(John) (.+?) ";       // "John" followed by a space, and then one or more characters.
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(text);

        while( matcher.find() )
            System.out.println( "found: " + matcher.group(1) + " " + matcher.group(2) );

    }

    /* Groups */
    private static void example3() {
        String text    =
                "John writes about this, and John writes about that," +
                        " and John writes about everything. ";
        String patternStr = "(John)";       // there exists only one group that is group(1) is "John"
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(text);

        while( matcher.find() )
            System.out.println("found: " + matcher.group(1) + " at " + matcher.start() + " - " + matcher.end());
    }

    /* find start end reset*/
    private static void example2() {
        //  If multiple matches can be found in the text, the find() method will find the first,
        //  and then for each subsequent call to find() it will move to the next match.

        // The methods start() and end() will give the indexes into the text where the found match starts and ends.
        // Actually end() returns the index of the character just after the end of the matching section.

        String text    =
                "This is the text which is to be searched " +
                        "for occurrences of the word 'is'.";
        String patternString = "is";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);

        int count = 0;
        while ( matcher.find() ) {
            ++count;
            System.out.println( "found: " + count + " : " + matcher.start() +  " - " + matcher.end());
        }

        matcher.reset();
        // The Matcher reset() method resets the matching state internally in the Matcher.
        // In case you have started matching occurrences in a string via the find() method,
        // the Matcher will internally keep a state about how far it has searched through the input text.
        // By calling reset() the matching will start from the beginning of the text again.
    }

    /* matches - lookingAt*/
    private static void example1() {
        String text    =
                "This is the text to be searched " +
                        "for occurrences of the http:// pattern.";

        String patternString = "This is the";

        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        System.out.println("lookingAt = " + matcher.lookingAt());       // beginning of the text must match with pattern
        System.out.println("matches   = " + matcher.matches());         // whole text must match with the pattern

    }
}
