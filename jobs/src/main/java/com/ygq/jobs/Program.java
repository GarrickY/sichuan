package com.ygq.jobs;


import com.ygq.jobs.json.Json2Object;

public class Program {
    public static void main(String[] para) {

        Json2Object jp = new Json2Object();
        jp.parseToCmsContent();
        jp.parseToCmsContentPlus();
        jp.object2String();
        System.out.println("End");
    }
}
