package com.ygq.jobs.exception;


public class ExceptionTest {

    public void handleException(){
        try {
            //throwException();
            throwEception2();
        }
        catch (Exception e){
            //e.printStackTrace();
            System.out.println("here is message");
            System.out.println(e.getMessage());
        }
    }

    private void throwException() throws Exception {
        int a=50;
        int b=5;
        int c=0;
        int d=a/c;
    }

    private void throwEception2(){
        int a = 5;
        throw new NullPointerException();
    }

}
