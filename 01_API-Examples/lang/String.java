import java.lang.String;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("First String: ");
        String str1 = in.nextLine();
        System.out.print("Second String: ");
        String str2 = in.nextLine();

        /* int compareTo(String anotherString )*/

        if( str1.compareTo(str2) == 0){
            System.out.println("Strings are equal to each other");
        }else if( str1.compareTo(str2) > 0){
            System.out.println("First String lexicographically greater than the second one");
        }else if( str1.compareTo(str2) < 0){
            System.out.println("First String lexicographically less than the second one");
        }

        /* String substring(int beginningIndex) */
        /* String substring(int beginIndex, int endIndex) */

        if( str1.length() > 5) {
            System.out.println("First 0-5: " + str1.substring(0, 5));
            System.out.println("After 5-end: " + str1.substring(5));
        }

        /*   String toLowerCase() */
        /*   String toUpperCase() */
        System.out.println( "ToUppercase : " + str1.toUpperCase() );
        System.out.println( "ToLowerCase : " + str2.toLowerCase() );

        /* String repeat(int count) */
        System.out.println("repeat 5 times: " + str1.repeat(5));
    }

}
