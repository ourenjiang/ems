package org.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CallMethod {
    public void testGetMethod() {
        Class stdClass = Student.class;
        // 获取public方法getScore，参数为String:
        try {
            System.out.println(stdClass.getMethod("getScore", String.class));
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        // 获取继承的public方法getName，无参数:
        try {
            System.out.println(stdClass.getMethod("getName"));
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        // 获取private方法getGrade，参数为int:
        try {
            System.out.println(stdClass.getDeclaredMethod("getGrade", int.class));
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        // 获取private方法getGrade，参数为int:
        try {
            System.out.println(stdClass.getDeclaredMethod("getGrade2", int.class, String.class));
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        System.out.println("--------------------------------------------\n");
    }

    public void testCallMethod1() {
        // String对象:
        String s = "Hello world";
        // 获取String substring(int)方法，参数为int:
        try {
            Method substring = String.class.getMethod("substring", int.class);

            // 在s对象上调用该方法并获取结果:
            String r = (String) substring.invoke(s, 6);
            // 打印调用结果:
            System.out.println(r); // "world"
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        System.out.println("--------------------------------------------\n");
    }

    public void testCallMethod2() {
        // String对象:
        String s = "Hello world";
        // 获取String substring(int)方法，参数为int:
        try {
            Method substring = String.class.getMethod("substring", int.class, int.class);

            // 在s对象上调用该方法并获取结果:
            String r = (String) substring.invoke(s, 6, 7);
            // 打印调用结果:
            System.out.println(r); // "world"
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        System.out.println("--------------------------------------------\n");
    }

    public void testCallStaticMethod() {
        // 获取Integer.parseInt(String)方法，参数为String:
        Method m = null;
        try {
            m = Integer.class.getMethod("parseInt", String.class);

            // 调用该静态方法并获取结果:
            Integer n = (Integer) m.invoke(null, "12345");
            // 打印调用结果:
            System.out.println(n);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        System.out.println("--------------------------------------------\n");
    }

    public void testCallNonPublicMethod() {
        Person p = new Person();
        Method m = null;
        try {
            m = p.getClass().getDeclaredMethod("setName", String.class);

            m.setAccessible(true);
            m.invoke(p, "Bob");
            System.out.println(p.name);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        System.out.println("--------------------------------------------\n");
    }

    class Student extends Person {

        public int getScore(String type) {
            return 99;
        }

        private int getGrade(int year) {
            return 1;
        }

        private int getGrade2(int year, String type) {
            return 1;
        }
    }

    class Person {
        String name;

        private void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return "Person";
        }
    }
}
