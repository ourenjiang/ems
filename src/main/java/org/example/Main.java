package org.example;

import org.example.learn.MyObject;

import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MyObject myObject = new MyObject();
        System.out.println(myObject.toString());
        System.out.println(myObject.getClass());
        System.out.println(myObject.clone());
        System.out.println(myObject);

        // 序列化
        MyObject myObject1 = new MyObject();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.dat"))) {
            oos.writeObject(myObject1);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 反序列化
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.dat"))) {
            MyObject restoredPerson = (MyObject) ois.readObject();
            System.out.println("反序列化结果: " + restoredPerson);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}