package com.ygq.jobs;


import com.ygq.jobs.json.Reader;

public class Program {
    public static void main(String[] para) {

        Reader r = new Reader();
        //r.printJson();
        r.readJson();
        System.out.println("End");
    }
}
