package PlayGround;

public class Main {

    public static void main(String[] args) {
        Thread myThread = new Thread( ()->{
            try{
                Thread.sleep(5000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        } );
        printThreadState(myThread);

        myThread.start();
        printThreadState(myThread);         // In runnable state, thread may or may not be running it is up to the OS

        Thread waitingThread = new Thread( ()->{
            System.out.println("Somethings...");
            try {
                myThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } );
        waitingThread.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        printThreadState(waitingThread);
        printThreadState(myThread);

        Thread anotherThread = new Thread( ()->{
            System.out.println("Another Thread");
        } );
        anotherThread.start();



    }

    public static void printThreadState(Thread t){
        System.out.println("Current Thread State: " + t.getState());
    }

}
