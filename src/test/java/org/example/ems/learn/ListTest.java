package org.example.ems.learn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(10);
        Integer integer10 = 10;
        integerList.add(integer10);

        integerList.add(13);
        integerList.add(10);
        System.out.println(integerList);

        integerList.remove(integer10);
        System.out.println(integerList);


    }
}
