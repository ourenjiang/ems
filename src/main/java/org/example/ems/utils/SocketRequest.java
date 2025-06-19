package org.example.ems.utils;

import java.util.Optional;

public class SocketRequest {

    private SocketClient socketClient;

    SocketRequest(String host, int port){
        socketClient = new SocketClient(host, port);
    }

    public byte[] writeAndRead(byte[] message){
        try{
            socketClient.write(message);
            byte[] read = socketClient.read();
            return read;
        }catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }
}
