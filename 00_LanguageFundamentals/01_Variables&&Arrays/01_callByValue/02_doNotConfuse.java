public class Main {

    public void tryMe( ) {
        int x = 1, y = 2;
        System.out.println("Before : " + x + ", " + y );
        int temp;
        temp = x;
        x = y;
        y = temp;
        System.out.println("After: " + x + ", " + y );

        Integer sarma1 = 3;
        Integer sarma2 = 5;
        System.out.println("Before : " + sarma1 + ", " + sarma2 );
        Integer gecici = sarma1;
        sarma1 = sarma2;
        sarma2 = gecici;
        System.out.println("After: " + sarma1 + ", " + sarma2 );
    }
    public static void main(String[] args) {
        Main test = new Main();
        // We don't pass around anything just do the process inside one function so no problem, no limitation of pass by value
        test.tryMe();
    }

}