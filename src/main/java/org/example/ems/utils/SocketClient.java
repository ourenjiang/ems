package org.example.ems.utils;

import java.io.*;
import java.net.Socket;
import java.nio.channels.SocketChannel;

public class SocketClient {
    Socket socket;

    SocketClient() {
    }

    public SocketClient(String host, int port) {
        try {
            socket = new Socket(host, port);
            socket.setSoTimeout(5000);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isConnected() {
        if (socket != null) {
            return socket.isConnected();
        }
        return false;
    }

    void writeLine(String message) {
        if (!this.isConnected()) {
            throw new RuntimeException("写失败，套接字未连接!");
        }

        try {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String readLine() {
        if (!this.isConnected()) {
            throw new RuntimeException("读失败，套接字未连接!");
        }

        String result;
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            result = bufferedReader.readLine();
            if (result == null) {
                // 对端正常关闭
                throw new RuntimeException("对端正常关闭");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public byte[] read() {
        if (!this.isConnected()) {
            throw new RuntimeException("读失败，套接字未连接!");
        }

        byte[] result = new byte[8192];
        int resultLength = 0;// 有效长度

        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());

            byte[] buffer = new byte[8192]; // 8KB缓冲区
            int bytesRead = bufferedInputStream.read(buffer);
            if (bytesRead != -1) {
                int newLength = result.length + bytesRead;
                byte[] newResult = new byte[newLength];

                // <有效长度> 不超出 <实际容量>
                if (resultLength < result.length) {
                    // 拼接数据
                    System.arraycopy(buffer, 0, result, resultLength, bytesRead);
                    resultLength += bytesRead;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        byte[] result2 = new byte[resultLength];
        System.arraycopy(result, 0, result2, 0, resultLength);
        return result2;
    }

    void write(byte[] message) {
        if (!this.isConnected()) {
            throw new RuntimeException("写失败，套接字未连接!");
        }

        try {
//            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
//            bufferedOutputStream.write(message);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(message);
            outputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
