package org.example;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class MyField {

    public void testStringField(){
        try {
            Field value = String.class.getDeclaredField("value");

            value.getName(); // "value"
            value.getType(); // class [B 表示byte[]类型
            int m = value.getModifiers();
            Modifier.isFinal(m); // true
            Modifier.isPublic(m); // false
            Modifier.isProtected(m); // false
            Modifier.isPrivate(m); // true
            Modifier.isStatic(m); // false
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        System.out.println("--------------------------------------------\n");
    }
    public void run() {
        Class stdClass = Student.class;

        // 获取public字段"score":
        try {
            System.out.println(stdClass.getField("score"));
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        // 获取继承的public字段"name":
        try {
            System.out.println(stdClass.getField("name"));
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        // 获取private字段"grade":
        try {
            System.out.println(stdClass.getDeclaredField("grade"));
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        System.out.println("--------------------------------------------\n");
    }

    class Student extends Person {
        public int score;
        private int grade;
    }

    class Person {
        public String name;
    }
}
