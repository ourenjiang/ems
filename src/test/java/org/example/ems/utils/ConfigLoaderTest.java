package org.example.ems.utils;

import java.util.List;
import java.util.Map;

public class ConfigLoaderTest {
    public static void main(String[] args) {
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
}
