package com.ygq.jobs.io;

import java.io.*;

public class WriteFiles {

    private String currentDir = Class.class.getClass().getResource("/").getPath();

    public void writeEverything(){
        writeMsg1();
        writeMsg2();
        writeMsg3();
        writeMsg4();
    }

    private void writeMsg1(){
        String file = currentDir+"data/testfile1.txt";
        try{
            FileWriter writer=new FileWriter(file);
            writer.write("welcome boy!");
            writer.write("I'm ok");
            writer.flush();
            writer.close();

        }catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    private void writeMsg2() {
        String file = currentDir + "data/testfile2.txt";
        try {
            FileOutputStream fo = new FileOutputStream(file);

            fo.write("12345".getBytes());
            fo.flush();
            fo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeMsg3(){
        String file = currentDir + "data/testfile3.txt";
        try {
            FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream out = new BufferedOutputStream(fos);
            byte[] msg=new byte[]{65,66,68,69,70};
            out.write(msg);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeMsg4(){
        String file = currentDir + "data/testfile4.txt";
        try {
            FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream out = new BufferedOutputStream(fos);
            out.write(73);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
