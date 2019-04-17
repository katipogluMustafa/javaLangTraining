
import java.security.SecureRandom;
import java.util.Random;

public class Test {
    public static void main(String... args) {

        System.out.print("Using Random ");
        heads_and_tails(new Random());
        System.out.print("\nUsing SecureRandom ");
        heads_and_tails(new SecureRandom());

        System.out.println("\nUsing Random ");
        roll_die(new Random());
        System.out.println("\nUsing SecureRandom ");
        roll_die(new SecureRandom());

    }

    public static void heads_and_tails(Random s){
        int count_1 = 0, count_0 = 0;
        for (int i = 0; i < 1_000_000; i++)
            if( s.nextInt(2) == 0)
                count_0++;
            else
                count_1++;
        double rate = count_0 / (double)( count_0 + count_1 );
        System.out.printf("Probability of Coming \n head is : %f\n tail is : %f",rate, 1.0-rate);
    }

    public static void roll_die(Random randomNumbers){

        int frequency1 = 0; // count of 1s rolled
        int frequency2 = 0; // count of 2s rolled
        int frequency3 = 0; // count of 3s rolled
        int frequency4 = 0; // count of 4s rolled
        int frequency5 = 0; // count of 5s rolled
        int frequency6 = 0; // count of 6s rolled

        // tally counts for 60,000,000 rolls of a die
        for (int roll = 1; roll <= 60_000_000; roll++) {
            int face = 1 + randomNumbers.nextInt(6); // number from 1 to 6

            // use face value 1-6 to determine which counter to increment
            switch (face) {
                case 1:
                    ++frequency1; // increment the 1s counter
                    break;
                case 2:
                    ++frequency2; // increment the 2s counter
                    break;
                case 3:
                    ++frequency3; // increment the 3s counter
                    break;
                case 4:
                    ++frequency4; // increment the 4s counter
                    break;
                case 5:
                    ++frequency5; // increment the 5s counter
                    break;
                case 6:
                    ++frequency6; // increment the 6s counter
                    break;
            }
        }

        System.out.println("Face\tFrequency"); // output headers
        System.out.printf("1\t%d%n2\t%d%n3\t%d%n4\t%d%n5\t%d%n6\t%d%n",
                frequency1, frequency2, frequency3, frequency4,
                frequency5, frequency6);
    }

}
