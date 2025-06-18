package org.example.ems.utils;

public class SocketClientTest {
    public static void main(String[] args) {

        // 第一步，先创建一个全局的套接字句柄，用于关联业务代码和重连代码
        SocketClient localhost;

        // 思路：一直连接，直到连接成功。
        while (true) {
            try {
                localhost = new SocketClient("localhost", 8888);
                System.out.println("连接成功");
                break;
            } catch (RuntimeException e) {
                System.out.println("连接失败: " + e);
                continue;//重新连接
            }
        }

        // 开始处理业务代码
        // 其间，也处理连接异常，即重连
        while (true) {
            try {
                String s = localhost.readLine();
                System.out.println("接收：" + s);
            } catch (RuntimeException e) {
                System.out.println("读取数据失败: " + e);
                System.out.println("尝试重连");

                // 开始尝试重连
                while (true) {
                    try {
                        localhost = new SocketClient("localhost", 8888);
                        System.out.println("连接成功");
                        break;
                    } catch (RuntimeException e2) {
                        System.out.println("连接失败: " + e2);
                        continue;//重新连接
                    }
                }
            }
        }
    }
}
