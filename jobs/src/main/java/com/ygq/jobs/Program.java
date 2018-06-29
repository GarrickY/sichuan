package com.ygq.jobs;


import com.ygq.jobs.exception.ExceptionTest;

public class Program {
    public static void main(String[] para) {
        ExceptionTest et = new ExceptionTest();
        et.handleException();
        System.out.println("End");
    }
}
