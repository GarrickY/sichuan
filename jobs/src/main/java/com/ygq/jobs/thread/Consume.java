package com.ygq.jobs.thread;

import org.apache.log4j.Logger;

public class Consume implements Runnable {

    static Logger logger = Logger.getLogger(Consume.class);

    public void run() {
        while (true) {
            try {
                if (MultiThreadTest.store.size() > 0) {

                    String product = MultiThreadTest.store.take().toString();
                    logger.warn(String.format("buy a product:%s and %s product left.", product, MultiThreadTest.store.size()));
                } else {
                    logger.error("No more product in the store.");
                }
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                System.out.println("Consume has an error");
            }
        }
    }
}
