import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random generator = new Random();
        System.out.println( generator.nextBoolean() );
        System.out.println( generator.nextDouble() );
        System.out.println( generator.nextFloat()  );
        System.out.println( generator.nextInt() );
        System.out.println( generator.nextInt(25) );
        System.out.println( generator.nextLong() );
    }

}