package com.ygq.jobs.thread;

import org.apache.log4j.Logger;

public class Produce implements Runnable {

    static Logger logger = Logger.getLogger(Consume.class);

    public void run() {
        int cnt = 0;
        while (true) {
            try {
                if (MultiThreadTest.store.size() < 50) {

                    MultiThreadTest.store.add("pc" + ++cnt);
                    logger.info(String.format("produce a product. and %s product left.", MultiThreadTest.store.size()));
                } else {
                    logger.error("Store is full. try to produce later.");
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Produce has an error");
            }
        }
    }
}
