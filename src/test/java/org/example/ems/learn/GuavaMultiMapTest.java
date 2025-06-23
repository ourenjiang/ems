package org.example.ems.learn;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class GuavaMultiMapTest {
    public static void main(String[] args) {
        // 创建 MultiMap 实例
        Multimap<String, String> multiMap = ArrayListMultimap.create();

        // 添加键值对（允许一键多值）
        multiMap.put("Fruits", "Apple");
        multiMap.put("Fruits", "Banana");
        multiMap.put("Vegetables", "Carrot");
        multiMap.put("Fruits", "Apple"); // 允许重复值

        // 查询值
        System.out.println(multiMap.get("Fruits"));
        // 输出：[Apple, Banana, Apple]（保留插入顺序和重复值）

        // 遍历所有键值
        multiMap.forEach((key, value) ->
                System.out.println(key + " -> " + value)
        );
    }
}
