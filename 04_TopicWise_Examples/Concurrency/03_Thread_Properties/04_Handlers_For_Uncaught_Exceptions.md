# Handlers for Uncaught Exceptions

The run method of a thread cannot throw any checked exceptions, but it can be terminated by an unchecked exception. In that case, the thread dies.

* However, there is no catch clause to which the exception can be propagated.

* Instead, just before the thread dies, the exception is passed to a handler for uncaught exceptions.

* The handler must belong to a class that implements the Thread.UncaughtExceptionHandler interface. That interface has a single method,
     ````java
     void uncaughtException(Thread t, Throwable e)
    ````
    * You can install a handler into any thread with the setUncaughtExceptionHandler method.
    * You can also install a default handler for all threads with the static method setDefaultUncaughtExceptionHandler of the Thread class.
    * A replacement handler might use the logging API to send reports of uncaught exceptions into a log file.
        
* If you don’t install a default handler, the default handler is null. 
    * However, if you don’t install a handler for an individual thread, the handler is the thread’s ThreadGroup object.

>A thread group is a collection of threads that can be managed together. By default, all threads that you create belong to the same thread group, but it is possible to establish other groupings. Since there are now better features for operating on collections of threads, we recommend that you do not use thread groups in your programs.

* The ThreadGroup class implements the Thread.UncaughtExceptionHandler interface. 
    * Its uncaughtException method takes the following action:
        * If the thread group has a parent, then the uncaughtException method of the parent group is called.
        * Otherwise, if the Thread.getDefaultUncaughtExceptionHandler method returns a non-null handler, it is called.
        * Otherwise, if the Throwable is an instance of ThreadDeath, nothing happens.
        * Otherwise, the name of the thread and the stack trace of the Throwable are printed on System.err.