package org.example.ems.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MySocketClient {
    public static void main(String[] args){
        System.out.println("hello world");

        try(Socket socket = new Socket("localhost", 8888)){
            System.out.println("socket client connect success");

            try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                // 3. 发送消息
                out.println("hello, i'm a socket client");

                char[] buf = new char[3];
                // 4. 读取响应
                int size = in.read(buf, 0, 3);
                System.out.println("服务器响应: " + new String(buf));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
