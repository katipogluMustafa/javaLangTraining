package PlayGround;

public class Main {

    public static void main(String[] args){

        // By Extending Thread Class
        Thread myOwn = new MyOwnThread("My Thread");
        //-> thread is not started yet, we'll start it after the last thread created

        // By Using Anonymous Inner Classes
        Runnable anonymousRunnable = new Runnable(){
            @Override
            public void run(){
                System.out.println("Writing from Anonymous Runnable");
                try{
                    Thread.sleep(10000);
                    System.out.println("After The Looong Break");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        new Thread(anonymousRunnable).start();      // Do not save to thread anywhere, just start executing the thread

        // By Using Lambda Expression
        Runnable myRunnable = ()->{
            try{
                myOwn.join();                           // since we join to 'myOwn' thread, even though this thread starts before the other one
            }catch (InterruptedException e){            // Writing from My Runnable sentence is seen after 'myOwn' thread executed
                e.printStackTrace();
            }
            System.out.println("Writing From My Runnable");
            System.out.println(":)");
        };
        new Thread(myRunnable).start();


        myOwn.start();                              // MyOwn Thread Execution started

        /* Short hand Notation */
        Thread myThreadd = new Thread( ()->{
            // Do Something
        } );
        // then call myThreadd.start();

        Thread t = new Thread(()->{
            System.out.println("Running from " + Thread.currentThread().getName() );
        });
        t.setName("New Name of the thread");        // set the thread name
        t.start();

    }

}
