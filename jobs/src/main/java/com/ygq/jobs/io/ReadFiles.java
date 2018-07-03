package com.ygq.jobs.io;

import java.io.*;
import java.nio.ByteOrder;
import java.nio.CharBuffer;

public class ReadFiles {
    private String currentDir = Class.class.getClass().getResource("/").getPath();
    public void readEverything(){
        readMsg1();
        readMsg2();

    }

    private void readMsg1(){
        String file = currentDir+"data/testfile1.txt";
        try{
            FileReader reader=new FileReader(file);
            System.out.println(reader.getEncoding());
            int x = reader.read();

            char[] chars = new char[50];
            int y = reader.read(chars);
            System.out.println(String.valueOf(chars).toString());

            CharBuffer cb = CharBuffer.allocate(50);
            int z = reader.read(cb);
            System.out.println(cb.toString());

            reader.close();

        }catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    private void readMsg2() {
        String file = currentDir + "data/testfile2.txt";
        try {
            FileInputStream fo = new FileInputStream(file);
            int x = fo.read();
            byte[] w = new byte[50];
            int y = fo.read(w);
            System.out.println(new String(w));

            fo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
