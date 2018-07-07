package com.ygq.jobs.xml;

import org.apache.log4j.Logger;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

public class SerializeXmlFile {
    private URL smpFile = Thread.currentThread().getContextClassLoader().getResource("data/sample.xml");
    private URL smpFile1 = Thread.currentThread().getContextClassLoader().getResource("data/sample1.txt");

    private Logger logger = Logger.getLogger(XmlOperation.class);

    public void serializeXml(String xmlFile) {
        if (xmlFile == null || xmlFile == "") {
            xmlFile = smpFile.getPath();
        }

        Countries countries = new Countries();

        final Province p = new Province();
        p.name = "Guizhou";
        p.area = "250000";
        p.people = "4000";
        p.gdp = "5900";


        Provinces ps = new Provinces();
        try {
            ps.province = new ArrayList<Province>();
            ps.province.add(p);
        } catch (Exception e) {
            e.printStackTrace();
        }


        Country c = new Country();
        c.name = "Canada";
        c.phoneCode = "2";
        c.provinces = ps;
        countries.country = new ArrayList<Country>();

        countries.country.add(c);
        try {

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(smpFile1.getPath()));
            oos.writeObject(countries);
            oos.flush();
            oos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void deserializeXml(String text) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(smpFile.getPath()));
            Countries countries = (Countries) ois.readObject();
            System.out.println("");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
