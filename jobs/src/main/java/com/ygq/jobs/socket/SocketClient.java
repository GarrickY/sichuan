package com.ygq.jobs.socket;

import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class SocketClient extends Thread {

    public static void main(String[] param) {
        try {
            System.out.println("input server ip:");
            Scanner scanner = new Scanner(System.in);
            String remoteIP = scanner.nextLine();
            String ip = remoteIP.length() <= 0 ? "127.0.0.1" : remoteIP;
            Socket client = new Socket(ip, 8800);
            System.out.println("Connected to server: " + client.getInetAddress().getHostAddress());
            SimpleDateFormat tf = new SimpleDateFormat("hh:mm:ss");

            SendMsg sender = new SendMsg(client);
            new Thread(sender).start();
            ReceiveMsg receiver = new ReceiveMsg(client);
            new Thread(receiver).start();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
