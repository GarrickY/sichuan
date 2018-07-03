package com.ygq.jobs.socket;

import java.io.BufferedOutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SendMsg implements Runnable {
    SimpleDateFormat tf = new SimpleDateFormat("hh:mm:ss");
    Socket s;

    public SendMsg(Socket sk) {
        s = sk;
    }

    public void run() {
        while (true) {
            try {
                BufferedOutputStream os = new BufferedOutputStream(s.getOutputStream());
                String response = (new Scanner(System.in)).nextLine();
                System.out.println(tf.format(new Date()) + " Me: ");
                System.out.println(response);
                os.write(response.getBytes());
                os.flush();
                os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
