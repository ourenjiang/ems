package org.example.ems.utils;

import java.util.HexFormat;

public class SocketRequestTest {
    public static void main(String[] args) {
        SocketRequest socketRequest = new SocketRequest("localhost", 1504);

        while (true) {
            try {
//                byte[] requestFrame = {0x00, 0x04, 0x00, 0x00, 0x00, 0x06, 0x01, 0x03, 0x03, 0x00, 0x00, 0x53};
                String requestFrameString = "00 04 00 00 00 06 01 03 03 00 00 53";
                byte[] requestFrame =  HexFormat.of().parseHex(requestFrameString.replace(" ", ""));
                byte[] hellos = socketRequest.writeAndRead(requestFrame);
                String s = HexFormat.ofDelimiter(" ").formatHex(hellos);
                System.out.println(s);
                System.out.println("-----------------------------------------------------------\n");
            } catch (RuntimeException e) {
                System.out.println(e);
            }
        }
    }
}
