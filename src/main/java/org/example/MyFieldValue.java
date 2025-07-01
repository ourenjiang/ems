package org.example;

import java.lang.reflect.Field;

public class MyFieldValue {
    public void testGetValue() {

        Object p = new Person("Xiao Ming");
        Class c = p.getClass();

        try {
            Field f = c.getDeclaredField("name");
            Object value = f.get(p);
            System.out.println(value); // "Xiao Ming"
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        System.out.println("--------------------------------------------\n");
    }

    public void testSetValue() {
        Person p = new Person("Xiao Ming");
        System.out.println(p.getName()); // "Xiao Ming"
        Class c = p.getClass();
        try {
            Field name = c.getDeclaredField("name");
            name.setAccessible(true);
            name.set(p, "Xiao Hong");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        System.out.println(p.getName()); // "Xiao Hong"
        System.out.println("--------------------------------------------\n");
    }

    class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }
}
