package org.example;

import org.example.mycollections.MyHashMap;
import org.example.mycollections.MyTreeMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MyHashMap myMap = new MyHashMap();
        myMap.run();
        System.out.println("-----------------------------------------");

        myMap.run2();
        System.out.println("-----------------------------------------");

        MyTreeMap myTreeMap = new MyTreeMap();
        myTreeMap.run();
        System.out.println("-----------------------------------------");

        myTreeMap.run2();
        System.out.println("-----------------------------------------");

        myTreeMap.run3();
        System.out.println("-----------------------------------------");
    }
}