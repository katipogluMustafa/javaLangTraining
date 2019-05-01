# Thread Priorities

* Every thread has a priority.

* By default, a thread inherits the priority of the thread that constructed it.

* You can increase or decrease the priority of any thread with the setPriority method.
    * You can set the priority to any value between 
        * MIN_PRIORITY (defined as 1 in the Thread class)
        * NORM_PRIORITY (is defined as 5)
        * MAX_PRIORITY (defined as 10)

````java
Thread t = new Thread(()->{
    System.out.println("Running...");
});
t.setPriority(Thread.MIN_PRIORITY);
t.start();
````

## System Dependency
 Whenever the thread scheduler has a chance to pick a new thread, it prefers threads with higher priority. However, thread priorities are highly system-dependent.

For example, 
* Windows has seven priority levels. Some of the Java priorities will map to the same operating system level. 
* In the Oracle JVM for Linux, thread priorities are ignored altogether—all threads have the same priority.

> Thread priorities may have been useful in early versions of Java that didn’t use operating systems threads. You should not use them nowadays.
