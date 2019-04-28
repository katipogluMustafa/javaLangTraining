
import java.util.Calendar;
public class Main {

    public static void main(String[] args) {
        // Current Time and Date
        Calendar current = Calendar.getInstance();
        System.out.println(current.getTime());
        printDateWithHand(current);

        // 5000 Years Later
        current.add(Calendar.YEAR, 5000);
        System.out.println( current.getTime() );
        printDateWithHand( current );

        printMax(current);

        // 8000 Years Before
        current.add(Calendar.YEAR, -8000);
        System.out.println( current.getTime() );

    }

    public static  void printMax(Calendar calendar){

        System.out.println("\n Max Day Of Week is " + calendar.getMaximum(Calendar.DAY_OF_WEEK ));
        System.out.println(" Max Day Of Month is " +  calendar.getMaximum(Calendar.DAY_OF_MONTH) );
        System.out.println(" Max Day Of Year is " +  calendar.getMaximum(Calendar.DAY_OF_YEAR) );

        System.out.println(" Max Week Of Year is " + calendar.getMaximum(Calendar.WEEK_OF_YEAR) );
    }

    public static void printDateWithHand( Calendar calendar){
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DATE);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        int sec = calendar.get(Calendar.SECOND);
        System.out.println(day + "." + month + "." + year
                + "\n" + hour + ":" + min + " Passes " + sec + " Seconds"
        );
    }

}
