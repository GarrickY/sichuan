package com.ygq.jobs;


import com.ygq.jobs.property.PropertyOperation;

public class Program {
    public static void main(String[] para) {

        try {
            String path = Program.class.getClassLoader().getResource(".").getPath() + "test.properties";
            PropertyOperation p = new PropertyOperation();
            p.writePropertiesFile(path);

            p.readPropertiesFile(path);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("End");
    }
}
