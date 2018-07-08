package com.ygq.jobs.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MultiThreadTest {
    //https://www.cnblogs.com/wxd0108/p/5479442.html

    static BlockingQueue store = new ArrayBlockingQueue(100);

    public static void multiThreads() {
        Thread p1 = new Thread(new Produce());
        p1.start();
        System.out.println("Produce thread1 is started. Thread ID:" + p1.getId());
        Thread p2 = new Thread(new Produce());
        p2.start();
        System.out.println("Produce thread2 is started. Thread ID:" + p2.getId());

        Thread s1 = new Thread(new Consume());
        s1.start();
        System.out.println("Consume thread1 is started. Thread ID:" + s1.getId());

        Thread s2 = new Thread(new Consume());
        s2.start();
        System.out.println("Consume thread2 is started. Thread ID:" + s2.getId());

        Thread s3 = new Thread(new Consume());
        s3.start();
        System.out.println("Consume thread3 is started. Thread ID:" + s3.getId());
    }

}
