package org.example.ems.utils;

import java.io.*;
import java.net.Socket;

public class SocketClient {
    Socket socket;
    SocketClient(){
    }

    public SocketClient(String host, int port) {
        try {
            socket = new Socket(host, port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void writeLine(String message) {
        try {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String readLine(){
        String result;
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            result = bufferedReader.readLine();
            if(result == null){
                // 对端正常关闭
                throw new RuntimeException("对端正常关闭");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
