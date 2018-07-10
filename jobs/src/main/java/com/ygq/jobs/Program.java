package com.ygq.jobs;


import com.ygq.jobs.database.MongoDb;

public class Program {
    public static void main(String[] para) {

        MongoDb m = new MongoDb();
        m.connectToDatabase();
        System.out.println("End");
    }
}
