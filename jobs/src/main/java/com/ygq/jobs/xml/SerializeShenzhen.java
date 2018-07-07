package com.ygq.jobs.xml;

import com.thoughtworks.xstream.XStream;

import java.io.*;

public class SerializeShenzhen {

    public void object2File() {

        Shenzhen sz = new Shenzhen();
        sz.name = "pengcheng";
        sz.areaNumber = "9";
        sz.phoneCode = "0755";

        try {
            //serialized to object
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("sz.txt"));
            oos.writeObject(sz);
            oos.flush();
            oos.close();
            System.out.println(new File("sz.txt").length());

            //deserialized to object
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("sz.txt"));
            Shenzhen sz0 = (Shenzhen) ois.readObject();
            ois.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void serialize2XmlFormat() {
        Shenzhen sz = new Shenzhen();
        sz.name = "pengcheng";
        sz.areaNumber = "9";
        sz.phoneCode = "0755";

        try {
            XStream xsteam = new XStream();

            xsteam.toXML(sz, new FileOutputStream("sz2.xml"));


            String xmlStr = xsteam.toXML(sz);

            //deserialize xml file and update the file
            Shenzhen sz3 = (Shenzhen) xsteam.fromXML(new FileInputStream("sz2.xml"));
            sz3.name = "Pengchengdadidd";
            xsteam.toXML(sz3, new FileOutputStream("sz2.xml"));

            //deserialize xml string to object
            String xml = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><com.ygq.jobs.xml.Shenzhen><name>Pengchengdadidd</name><phoneCode>0755</phoneCode><areaNumber>9</areaNumber></com.ygq.jobs.xml.Shenzhen>";
            Shenzhen sz4 = (Shenzhen) xsteam.fromXML(xml);
            System.out.println(sz4);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
