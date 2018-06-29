package com.ygq.jobs.testng;

import fitnesse.slim.test.Sleep;
import org.testng.annotations.*;

public class TestDemo {

    @BeforeTest
    public void testNGSetup(){
        System.out.println("this is a setup method.");
    }

    @Test
    public void testNGDoSth(){
        System.out.println("here we wait 1 seconds.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void testNGTearDown(){
        System.out.println("this is teardown method");
    }
}
