package com.ygq.jobs.testng;

import org.testng.annotations.*;

public class TestNGDemo {

    @DataProvider(name = "names")
    private Object[][] nameList(){
        Object[][] names = {{"garrick",23}, {"troy",34},{"marcus",42}};
        return names;
    }


    public void testNGSetup(){
        System.out.println("this is a setup method.");
    }

    @Parameters({"name","age"})
    @Test
    public void testNGDoSth(  String name,String age){
        System.out.println("My name is "+name + ", and age is "+age);
        System.out.println("here we wait 1 seconds.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(dataProvider = "names")
    public void testNGDoSth1(String name, int age){
        System.out.println("My name is "+name + ", and age is "+age);
        System.out.println("here we wait 1 seconds.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNGDoAnyth(){
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
