package PlayGround;

public class MyOwnThread extends Thread{

    // If you want to change the name of the thread, create own constructor
    public MyOwnThread( String threadName){
        super(threadName);
    }

    // Implement the action you want to perform inside run method
    @Override
    public void run(){
        System.out.println(" Writing from " + Thread.currentThread().getName());
    }

}
