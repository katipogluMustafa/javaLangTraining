package com.meshale.JavaLangTraining;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    //  A logger that is not referenced by any variable can be garbage-collected
    //  To prevent this, save a reference to the logger with a static variable
    private static final Logger myOwnLogger = Logger.getLogger("com.meshale.JavaLangTraining");

    public static void main(String[] args) {
       myOwnLogger.info("MyOwnLogger: Main Method Started");
       myOwnLogger.setLevel(Level.OFF);  // All logging is suppressed from now on.
       myOwnLogger.info("Continuing to execute main method");
    }

}
