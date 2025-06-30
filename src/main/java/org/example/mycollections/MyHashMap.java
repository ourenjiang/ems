package org.example.mycollections;

/*
 * Map : HashMap、Treemap、EnumMap
 * */

import java.util.HashMap;
import java.util.Map;

public class MyHashMap {

    Map<String, Integer> datas = new HashMap<>();

    public void run() {
        Student s = new Student("Xiao Ming", 99);
        Map<String, Student> map = new HashMap<>();
        map.put("Xiao Ming", s); // 将"Xiao Ming"和Student实例映射并关联
        Student target = map.get("Xiao Ming"); // 通过key查找并返回映射的Student实例
        System.out.println(target == s); // true，同一个实例
        System.out.println(target.score); // 99
        Student another = map.get("Bob"); // 通过另一个key查找
        System.out.println(another); // 未找到返回null
    }

    public void run2() {
        datas.put("hello", 1);
        datas.put("world", 2);

        //遍历键
        for (String key : datas.keySet()) {
            System.out.println("key: " + key);
        }

        //遍历值
        for (Integer value : datas.values()) {
            System.out.println("value: " + value);
        }

        // 遍历键值对
        for (Map.Entry<String, Integer> entry : datas.entrySet()) {
            System.out.println("entry: " + entry);
        }
    }
}

class Student {
    public String name;
    public int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}