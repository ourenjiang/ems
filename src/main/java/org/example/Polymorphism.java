package org.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Polymorphism {
    public void run() {
        // 获取Person的hello方法:
        try {
            Method hello = Person.class.getMethod("hello");

            // 对Student实例调用hello方法:
            hello.invoke(new Student());
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        System.out.println("--------------------------------------------\n");
    }

    class Person {
        public void hello() {
            System.out.println("Person:hello");
        }
    }

    class Student extends Person {
        @Override
        public void hello() {
            System.out.println("Student:hello");
        }
    }
}


