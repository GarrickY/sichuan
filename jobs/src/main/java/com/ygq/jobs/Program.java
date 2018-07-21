package com.ygq.jobs;


import com.ygq.jobs.reflection.ReflectOperation;

public class Program {
    public static void main(String[] para) {

        try {
            ReflectOperation ref = new ReflectOperation();
            ref.reflectClassInInternalPackage();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("End");
    }
}
