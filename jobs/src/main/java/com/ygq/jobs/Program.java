package com.ygq.jobs;


import com.ygq.jobs.sinterface.English;
import com.ygq.jobs.sinterface.IEnglish;

import java.util.Calendar;

public class Program {
    public static void main(String[] para) {

        Calendar c = Calendar.getInstance();
        System.out.println(String.format("%tr", c.getTime()));
        IEnglish english = new English();
        english.sayHello("Garrick");
        english.sayHappy();
        english.sayGoodbye("Yang");
        System.out.println("End");
    }
}
