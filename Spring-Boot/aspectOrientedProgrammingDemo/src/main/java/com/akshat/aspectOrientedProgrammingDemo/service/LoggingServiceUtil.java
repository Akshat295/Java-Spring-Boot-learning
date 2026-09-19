package com.akshat.aspectOrientedProgrammingDemo.service;

public class LoggingServiceUtil {

    public static void logStart(String className, String methodName) {
        System.out.println("executing --> " + className + "." + methodName);
    }

    public static void logEnd(String className, String methodName) {
        System.out.println("Finishing --> " + className + "." + methodName);
    }
}
