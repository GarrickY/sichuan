package com.ygq.jobs.unitest;

public class StaticDemo {
    private int c = 1000;

    public static int addStatic(int a, int b) {
        return a + b;
    }

    private static int addFive(int a) {
        System.out.println("Add 5");
        return a + 5;
    }

    public static int addStatic2(int a, int b) {
        return addFive(a + b);
    }

    public int add(int a, int b) {
        return a + b + 10;
    }

    private int addPrivate(int z) {
        return z + 10;
    }

    public int add2(int a, int b) {
        return addPrivate(a + b);
    }

    public int add3(int a, int b) {
        return a + b + c;
    }
}
