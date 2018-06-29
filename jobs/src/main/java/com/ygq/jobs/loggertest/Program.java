package com.ygq.jobs.loggertest;

public class Program {
    public static void main(String[] para) {

//        Log4jTest tester = new Log4jTest();
//        tester.writeSomethingToFile();
        JunitLogTest jlt=new JunitLogTest();
        jlt.writeSthLog();
        System.out.println("End");
    }
}
