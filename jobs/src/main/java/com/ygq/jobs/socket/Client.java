package com.ygq.jobs.socket;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public void createSocketClient(){
        String response;
        while (true) {
            try {
                Socket client = new Socket("127.0.0.1", 8899);
                System.out.println("please input something...");
                Scanner scanner = new Scanner(System.in);
                String p = scanner.nextLine();
                if (p.equals("bye")) {
                    client.close();
                    break;
                }

                //send data to server
                DataOutputStream out = new DataOutputStream(client.getOutputStream());
                out.writeUTF(p);

                //receive data from server
                DataInputStream in = new DataInputStream(client.getInputStream());
                response = in.readUTF();
                System.out.println("Response is "+response);
                System.out.println("hostname: "+client.getInetAddress().getHostName());
                System.out.println("remote socket addr"+client.getRemoteSocketAddress().toString());
                client.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] paras){
        Client c = new Client();
        c.createSocketClient();
    }
}
