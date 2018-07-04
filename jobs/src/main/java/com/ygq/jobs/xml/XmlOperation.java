package com.ygq.jobs.xml;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.List;


public class XmlOperation {
    URL smpFile = Thread.currentThread().getContextClassLoader().getResource("data/sample.xml");

    Logger logger = Logger.getLogger(XmlOperation.class);

    public void readXmlFile() {
        Document doc = null;
        try {
            SAXReader reader = new SAXReader();
            doc = reader.read(smpFile);

            Element root = doc.getRootElement();
            List<Element> elements = root.elements();
            logger.info("XML file root element:" + root.getName());

            String element = root.elementText("PhoneCode");


        } catch (Exception e) {
            logger.error("Read xml file error:");
            e.printStackTrace();
        }
    }
}

