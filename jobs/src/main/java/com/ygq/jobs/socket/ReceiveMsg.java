package com.ygq.jobs.socket;

import org.apache.log4j.Logger;

import java.io.BufferedInputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;

public class ReceiveMsg implements Runnable {

    static Logger logger = Logger.getLogger(ReceiveMsg.class);

    SimpleDateFormat tf = new SimpleDateFormat("hh:mm:ss");
    private Socket s;

    public ReceiveMsg(Socket sk) {
        s = sk;
    }

    public void run() {

        while (true) {
            try {
                BufferedInputStream is = new BufferedInputStream(s.getInputStream());
                byte[] buffer = new byte[1024 * 1024];

                int length;
                try {
                    length = is.read(buffer);
                    System.out.println(String.format("%s %s: ", tf.format(System.currentTimeMillis()), s.getInetAddress().getHostAddress()));
                    System.out.println(new String(buffer, 0, length));
                } catch (SocketTimeoutException e) {
                    continue;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
