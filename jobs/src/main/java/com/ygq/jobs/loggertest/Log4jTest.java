package com.ygq.jobs.loggertest;

import org.apache.log4j.Logger;

public class Log4jTest {
    private static Logger logger = Logger.getLogger(Log4jTest.class);

    public void writeSomethingToFile(){
        logger.debug("this is a test debug message");
        logger.error("this is a test error message");
        logger.trace("this is a trace message");
        logger.assertLog(3 < 2, "3 is larger than 2, good luck");
        logger.info("this is an info message");
        logger.warn("this is a warning message");
        logger.error("this is a test error11 message");
        logger.debug("this is a test debug22 message");
        Object lvl = logger.getLevel();
        System.out.println(lvl.toString());
    }
}
