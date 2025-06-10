package org.example;

import org.example.ems.device.air.custom.Device;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        ArrayList<Device> devices = new ArrayList<>();
        for(int i = 0; i < 1; ++i){
            Device device = new Device();
            device.start();
            devices.add(device);
        }

        // 注册 JVM 关闭钩子
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            for(Device device : devices){
                device.stop();
            }
            System.out.println("JVM 关闭，已清理资源");
        }));
    }
}