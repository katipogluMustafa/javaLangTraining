import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        double rand = Math.random(); // returns a random number between 0.0 and 1.0
        System.out.println("My Random Number: " +  rand);
        System.out.println("Number between range of 0 and 50: " + Math.random() * 50);
        System.out.println("Number between range of -20 and 30: " +  ( Math.random() * 50 - 20 ) );

    }

}
