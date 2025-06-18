package org.example.ems.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MySocketClient {
    public static void main(String[] args) {
        System.out.println("hello world");

        try {
            Socket socket = new Socket("127.0.0.1", 8888);
            System.out.println("socket client connect success");

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("hello, i'm a socket client");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                String buf = in.readLine();
                System.out.println("服务器响应: " + buf);
            }
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
