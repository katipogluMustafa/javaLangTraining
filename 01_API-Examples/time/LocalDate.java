import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();       // constructs an object that represents the current date.
        LocalDate specificDate = LocalDate.of(2019,5,21);

        if( specificDate.getDayOfWeek().getValue() == 1 )
            System.out.println("Monday");
        else if( specificDate.getDayOfWeek().getValue() == 7 )
            System.out.println("Sunday");

        printLocalDate(now,"now:");
        printLocalDate(specificDate,"specificDate:");

        now = now.minusDays(1000);
        printLocalDate(now, "1000 Days before now: ");

        specificDate = specificDate.plusDays(1000);
        printLocalDate(specificDate, "1000 Days later from specificDate: ");

    }

    public static void printLocalDate(LocalDate date){
        System.out.println( date.getYear() + "." + date.getMonth() + "." + date.getDayOfMonth() );
    }
    public static void printLocalDate(LocalDate date, String str){
        System.out.printf("%s: ",str);
        System.out.println( date.getYear() + "." + date.getMonth() + "." + date.getDayOfMonth() );
    }
}
