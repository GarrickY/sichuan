package com.ygq.jobs.socket;


import org.apache.log4j.Logger;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    private static Logger logger = Logger.getLogger(Server.class);

    @Override
    public void run(){
        try {
            ServerSocket server = new ServerSocket(8899,10);
            while (true){
                System.out.println("waiting...");
                Socket socket = server.accept();
                DataInputStream in = new DataInputStream(socket.getInputStream());
                String clientext = in.readUTF();
                System.out.println("client:"+clientext);

                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF("Hello, boy. you just said " + clientext);

                socket.close();

            }

        }
        catch (IOException e){
            logger.error(e.getStackTrace());
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Server s = new Server();
        Thread thread = new Thread(s);
        thread.start();
        System.out.println("here is main thread");
    }
}
