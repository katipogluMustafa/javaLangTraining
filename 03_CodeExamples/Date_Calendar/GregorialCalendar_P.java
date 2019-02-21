import java.util.GregorianCalendar;
import java.util.Calendar;
public class Main {
    public static void main(String[] args) {
        GregorianCalendar someDay = new GregorianCalendar(2019,2,21);
        someDay.add(Calendar.DAY_OF_MONTH, 10000  );        // 10 thousands days later

        System.out.println( " Year: " + someDay.get(Calendar.YEAR) );
        System.out.println( "Month: " + someDay.get(Calendar.MONTH) + 1 );  // months between 0 and 11
        System.out.println( "Day: "   + someDay.get(Calendar.DAY_OF_MONTH) );

        System.out.println( someDay.get(Calendar.YEAR) + "/" + (someDay.get(Calendar.MONTH)+1) + "/" + someDay.get(Calendar.DAY_OF_MONTH));
    }

}
