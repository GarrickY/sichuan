package com.ygq.jobs.xml;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.dom4j.tree.BaseElement;
import org.dom4j.tree.DefaultElement;

import java.io.FileOutputStream;
import java.net.URL;
import java.util.List;


public class XmlOperation {
    private URL smpFile = Thread.currentThread().getContextClassLoader().getResource("data/sample.xml");

    private Logger logger = Logger.getLogger(XmlOperation.class);

    public void readXmlFile() {
        Document doc;
        try {
            SAXReader reader = new SAXReader();
            doc = reader.read(smpFile);

            Element root = doc.getRootElement();
            List<Element> elements = root.elements();
            logger.info("XML file root element:" + root.getName());

            for (Element elt : elements) {
                if (elt.element("Provinces") != null) {
                    List<Element> provs = elt.element("Provinces").elements();
                    for (Element pro : provs) {
                        System.out.println("********************");
                        System.out.println("Provice Name:" + pro.element("Name").getText());
                        System.out.println("Provice Area:" + pro.element("Area").getText());
                        System.out.println("Provice People:" + pro.element("People").getText());
                        System.out.println("Provice Gdp:" + pro.element("Gdp").getText());
                    }
                }
            }
        } catch (Exception e) {
            logger.error("Read xml file error:");
            e.printStackTrace();
        }
    }

    public void modifyXmlFile() {
        Document doc;
        try {
            SAXReader reader = new SAXReader();
            doc = reader.read(smpFile);

            Element root = doc.getRootElement();
            Element newElement = new BaseElement("Country");
            Element usa = new DefaultElement("Name");
            usa.addText("USA");
            newElement.add(usa);

            root.add(newElement);

            XMLWriter writer = new XMLWriter(OutputFormat.createPrettyPrint());
            writer.setOutputStream(new FileOutputStream(smpFile.getFile()));

            writer.write(doc);
            writer.flush();
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}

