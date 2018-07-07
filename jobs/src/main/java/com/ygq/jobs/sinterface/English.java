package com.ygq.jobs.sinterface;

public class English implements IEnglish {
    public void sayHello(String name) {
        System.out.println("Hello" + name);
    }

    public void sayGoodbye(String name) {
        System.out.println(String.format("Goodbye %s, see you %s", name, "tommorow"));
    }

    public void sayHappy() {
        System.out.println("I am very happy");
    }
}
