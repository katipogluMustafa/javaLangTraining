

public class Main {

    public static void main(String... args) {

        Thread thread = new Thread( ()->{
            // When an Interrupt comes, we either choose to terminate, or continue working
            while( !Thread.currentThread().isInterrupted() ){       // We'll terminate if a termination request comes
                System.out.print(".");
            }
        } );
        thread.start();

        try {
            Thread.sleep(100);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        // Request termination for currently running thread by sending interrupt request
        thread.interrupt();

        // you can also check whether it is terminated or not
        if( thread.isInterrupted() )
            System.out.println("\n\nThread Successfully Interrupted");
        else
            System.out.println("Thread still running");

    }

}
