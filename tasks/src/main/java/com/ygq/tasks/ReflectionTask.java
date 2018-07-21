package com.ygq.tasks;

public class ReflectionTask {
    String taskName;
    String taskTitle;

    public ReflectionTask(String name, String job) {
        this.taskName = name;
        this.taskTitle = job;
        System.out.println("Class has been initialized");
    }

    public static int staticTestMethod() {
        System.out.println("this is a static method in ReflectionTask class.");
        return 0;
    }

    public void watchTv() {
        System.out.println(String.format("%s is watching TV.", taskName));
    }

    public void drinkMilk() {
        System.out.println(String.format("%s is drinking milk.", taskName));
    }

    private void privateTestMethod() {
        System.out.println("this is a private test method.");
    }

    public boolean sayHelloTask(String name, String msg) {
        System.out.println(String.format("%s, are you Ok? LX say %s to you", name, msg));
        return true;
    }
}

