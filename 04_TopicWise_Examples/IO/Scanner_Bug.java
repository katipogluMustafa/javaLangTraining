import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Name: ");
        String name = scan.nextLine();
        System.out.println("Age: ");
        int age = scan.nextInt();
        System.out.println("Born At: ");
        scan.nextLine();
        // Scanner has bug if you take String after basic types, you'll need to take one extra line before reading actual input.
        String place = scan.nextLine();

        printPerson(name,age,place);
    }

    private static void printPerson(String name, int age, String place) {
        System.out.println(name + " is " + age + " years old, born at " + place);
    }

}