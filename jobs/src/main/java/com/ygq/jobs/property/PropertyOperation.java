package com.ygq.jobs.property;

import java.io.*;
import java.util.Properties;

public class PropertyOperation {
    public void readPropertiesFile(String propertiesFile) throws IOException {
        InputStream input = new FileInputStream(propertiesFile);
        Properties prop = new Properties();
        prop.load(input);
        System.out.println("Country is " + prop.get("Country"));
    }

    public void writePropertiesFile(String propertiesFile) throws IOException {
        OutputStream outputStream = new FileOutputStream(propertiesFile);
        Properties prop = new Properties();
        prop.clear();
        prop.setProperty("Country", "China");
        prop.setProperty("Born", "Sichuan");
        prop.store(outputStream, "what can I say");
        outputStream.flush();
        outputStream.close();
    }
}
