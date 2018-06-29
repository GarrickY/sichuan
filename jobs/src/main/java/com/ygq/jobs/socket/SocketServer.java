package com.ygq.jobs.socket;

import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;

public class SocketServer {

    static SimpleDateFormat tf = new SimpleDateFormat("hh:mm:ss");

    public static void main(String[] param) {
        try {
            ServerSocket server = new ServerSocket(8800);
            System.out.println(tf.format(System.currentTimeMillis()) + " Server is listening...");
            Socket s = server.accept();
            System.out.println("Client is connected: " + s.getInetAddress().getHostAddress());
            SimpleDateFormat tf = new SimpleDateFormat("hh:mm:ss");

            ReceiveMsg receiver = new ReceiveMsg(s);
            new Thread(receiver).start();

            SendMsg sender = new SendMsg(s);
            new Thread(sender).start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}