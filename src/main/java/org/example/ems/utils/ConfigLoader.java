package org.example.ems.utils;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ConfigLoader {
    //    private static final String CONFIG_FILE = "application.yml";
    private static Map<String, Object> config;

    private static Map<String, Object> loadConfig(String fileName) {
        Map<String, Object> config = new HashMap<>();

        Yaml yaml = new Yaml();
        try (InputStream inputStream = ConfigLoader.class
                .getClassLoader()
                .getResourceAsStream(fileName)) {

            if (inputStream == null) {
                throw new RuntimeException("配置文件未找到: " + fileName);
            }

            config = yaml.load(inputStream);
        } catch (Exception e) {
            throw new RuntimeException("加载配置文件失败", e);
        }
        return config;
    }

    // 获取整个配置对象
    public static Map<String, Object> getConfig(String fileName) {
        config = loadConfig(fileName);
        return config;
    }

    // 获取嵌套配置值（使用点号分隔的路径）
    @SuppressWarnings("unchecked")
    public static <T> T getValue(String path) {
        String[] keys = path.split("\\.");
        Map<String, Object> current = config;

        for (int i = 0; i < keys.length - 1; i++) {
            Object obj = current.get(keys[i]);
            if (obj instanceof Map) {
                current = (Map<String, Object>) obj;
            } else {
                return null;
            }
        }

        return (T) current.get(keys[keys.length - 1]);
    }
}
