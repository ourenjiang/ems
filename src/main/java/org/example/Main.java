package org.example;

import org.example.ems.device.air.custom.Device;
import org.example.ems.utils.ConfigLoader;
import org.example.ems.utils.SocketClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        testConfigLoader();
    }

    public static void testConfigLoader() {
        // 获取整个配置
        Map<String, Object> fullConfig = ConfigLoader.getConfig();
        System.out.println("全量配置: " + fullConfig);

        // 获取具体值
        String appName = ConfigLoader.getValue("app.name");
        String dbUrl = ConfigLoader.getValue("database.url");
        Integer poolSize = ConfigLoader.getValue("database.pool-size");
        Boolean featureEnabled = ConfigLoader.getValue("features.enabled");

        System.out.println("应用名称: " + appName);
        System.out.println("数据库URL: " + dbUrl);
        System.out.println("连接池大小: " + poolSize);
        System.out.println("功能开关: " + featureEnabled);

        // 获取列表值
        List<String> options = ConfigLoader.getValue("features.options");
        System.out.println("功能选项: " + options);
    }

    public static void testSocketClient() {
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