package com.ygq.jobs.json;

import com.google.gson.annotations.Since;

import java.io.*;
import java.net.URI;
import java.nio.file.*;
import java.util.Iterator;

public class WriterJson {

    public void WriteToFile(){
        try {
            String filePath = Class.class.getClass().getResource("/").getPath() +"data/vantage-cms-modified.json";
            Reader reader=new Reader();
            FileWriter wr = new FileWriter(filePath,true);
            wr.write(reader.printJson() + "\r\nGood Luck!");
            wr.flush();
            wr.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
