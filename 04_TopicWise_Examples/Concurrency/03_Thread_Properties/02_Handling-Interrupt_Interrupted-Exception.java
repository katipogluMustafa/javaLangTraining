
public class Main {

    public static void main(String... args) {

        Runnable r = ()->{
            try{
                while( !Thread.currentThread().isInterrupted() ){       // Not necessary, see the below note
                    // Do Work
                    Thread.sleep(500);          // When we are at sleep, we blocked and cannot check interrupt flag
                    System.out.println("Still Running");
                }
            }catch (InterruptedException e){
                // Thread is interrupted during sleep or wait so it can not check it, we got the exception
            }finally {
                // Cleanup, if required
            }
        };

        /*
         * The isInterrupted check is neither necessary nor useful if you call the sleep method (or another interruptible method) after every work iteration.
         *   If you call the sleep method when the interrupted status is set, it doesn’t sleep. Instead, it clears the status (!) and throws an InterruptedException.
         *   Therefore, if your loop calls sleep, don’t check the interrupted status. Instead, catch the InterruptedException
         */
        Runnable y = ()->{
            try{
                while( true ){  // or any other condition
                    // Do Work
                    Thread.sleep(500);
                    System.out.println("Still Running");
                }
            }catch (InterruptedException e){
                // Thread is interrupted during sleep or wait so it can not check it, we got the exception
            }finally {
                // Cleanup, if required
            }
            // Exiting the run method
        };



        // Calling the static Thread.interrupted method clears the interrupted status of the thread.
        if( Thread.interrupted() )      // static method that checks whether the current thread has been interrupted.
            System.out.println("Main Thread interrupted");
        else
            System.out.println("Main thread is not interrupted");



        Thread thread = new Thread(()->{
            // isInterrupted method is an instance method that you can use to check whether any thread has been interrupted. Calling it does not change the interrupted status.
            if(Thread.currentThread().isInterrupted() )
                System.out.println("thread interrupted");
            else
                System.out.println("thread is not interrupted");
        });
        thread.start();



        Runnable runnable = ()->{
            // Do somethings
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                // Don't ignore the exception,
                Thread.currentThread().interrupt();         // set the interrupt flag, so that caller can test it
            }

            // Or, even better, tag your method with throws InterruptedException and drop the try block. Then the caller (or, ultimately, the run method) can catch it.
            // void mySubTask() throws InterruptedException
            //{
            //   . . .
            //   sleep(delay);
            //   . . .
            //}
        };

    }

}
