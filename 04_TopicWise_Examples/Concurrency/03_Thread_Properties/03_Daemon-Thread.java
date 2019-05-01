public class Main {

    public static void main(String... args) {
        /*
         * A daemon is simply a thread that has no other role in life than to serve others.
         * Examples are timer threads that send regular “timer ticks” to other threads or threads that clean up stale cache entries.
         * When only daemon threads remain, the virtual machine exits
         *
         * setDaemon() method must be called before the thread is started.
         */
        Thread clean_up_thread = new Thread(()->{
            // cache-cleanup
        });
        clean_up_thread.setDaemon(true);
    }


}