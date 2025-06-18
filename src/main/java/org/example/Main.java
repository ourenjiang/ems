package org.example;

import org.example.ems.device.air.custom.Device;
import org.example.ems.utils.SocketClient;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
//        // to see how IntelliJ IDEA suggests fixing it.
//
//        ArrayList<Device> devices = new ArrayList<>();
//        for(int i = 0; i < 1; ++i){
//            Device device = new Device();
//            device.start();
//            devices.add(device);
//        }
//
//        // 注册 JVM 关闭钩子
//        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
//            for(Device device : devices){
//                device.stop();
//            }
//            System.out.println("JVM 关闭，已清理资源");
//        }));

        // 第一步，先创建一个全局的套接字句柄，用于关联业务代码和重连代码
        SocketClient localhost;

        // 思路：一直连接，直到连接成功。
        while (true) {
            try {
                localhost = new SocketClient("192.168.10.1", 8888);
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