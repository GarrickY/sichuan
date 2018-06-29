package com.ygq.jobs.loggertest;


import java.util.logging.Level;
import java.util.logging.Logger;

public class JunitLogTest{
    private static Logger logger = Logger.getLogger("test");

    protected void writeSthLog() {
        logger.info("test info 1");
        logger.log(Level.WARNING,"this is a warning message");
        logger.warning("this is 2nd warning message");
    }
}
