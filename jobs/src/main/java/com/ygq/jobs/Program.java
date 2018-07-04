package com.ygq.jobs;


import com.ygq.jobs.xml.XmlOperation;

public class Program {
    public static void main(String[] para) {

        XmlOperation op = new XmlOperation();
        op.readXmlFile();
        System.out.println("End");
    }
}
