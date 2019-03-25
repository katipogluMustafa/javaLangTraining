package com.meshale.JavaLangTraining;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    public static void main(String[] args) {
       Logger.getGlobal().info("Main Method Started");
       Logger.getGlobal().setLevel(Level.OFF);  // All logging is suppressed from now on.
       Logger.getGlobal().info("Continuing to execute main method");
    }

}
