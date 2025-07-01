package org.example;

import java.util.Arrays;
import java.util.Comparator;

public class MyLambda {
    public void oldUsage(){
        String[] array = new String[] { "Apple", "Orange", "Banana", "Lemon" };
        System.out.println(String.join(", ", array));
        Arrays.sort(array, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
        System.out.println(String.join(", ", array));
        System.out.println("--------------------------------------------");
    }

    public void newUsage(){
        String[] array = new String[] { "Apple", "Orange", "Banana", "Lemon" };
        System.out.println(String.join(", ", array));

        Arrays.sort(array, (s1, s2) -> {
            return s1.compareTo(s2);
        });
        System.out.println(String.join(", ", array));
        System.out.println("--------------------------------------------");
    }
}
