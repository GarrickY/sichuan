package com.ygq.jobs;


import com.ygq.jobs.net.HttpOperation;

public class Program {
    public static void main(String[] para) {

        try {
            HttpOperation httpOperation = new HttpOperation();
            httpOperation.getRequest();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("End");
    }
}
