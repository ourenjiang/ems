package org.example.mycollections;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class MyTreeMap {

    // 常规用法
    public void run(){
        Map<String, Integer> map = new TreeMap<>();
        map.put("orange", 1);
        map.put("apple", 2);
        map.put("pear", 3);
        for (String key : map.keySet()) {
            System.out.println(key);
        }
        System.out.println("-----------------------------------------\n");
    }

    // 引用一个实现了Comparable接口的Key
    public void run2(){
        Map<MyKey, Integer> map = new TreeMap<>();
        map.put(new MyKey("aaa"), 1);
        map.put(new MyKey("bbb"), 2);
        map.put(new MyKey("ccc"), 3);

        for (MyKey key : map.keySet()) {
            System.out.println(key);
        }
        System.out.println("-----------------------------------------");

        for(Integer value : map.values()){
            System.out.println(value);
        }
        System.out.println("-----------------------------------------");

        for(Map.Entry<MyKey, Integer> entry : map.entrySet()){
            System.out.println(entry);
        }
        System.out.println("-----------------------------------------");

    }

    // 引用一个实现了Comparable接口的Key
    public void run3(){
        Map<MyKey2, Integer> map = new TreeMap<>(new Comparator<MyKey2>() {
            @Override
            public int compare(MyKey2 o1, MyKey2 o2) {
                return o1.getData().compareTo(o2.getData());
            }
        });

        map.put(new MyKey2("ddd"), 111);
        map.put(new MyKey2("fff"), 222);
        map.put(new MyKey2("eee"), 333);

        for (MyKey2 key : map.keySet()) {
            System.out.println(key);
        }
        System.out.println("-----------------------------------------");

        for(Integer value : map.values()){
            System.out.println(value);
        }
        System.out.println("-----------------------------------------");

        for(Map.Entry<MyKey2, Integer> entry : map.entrySet()){
            System.out.println(entry);
        }
        System.out.println("-----------------------------------------");

    }
}

class MyKey implements Comparable<MyKey>{

    MyKey(String data){
        this.data = data;
    }

    private String data = "";
    @Override
    public int compareTo(MyKey o) {
        return data.compareTo(o.data);
    }
}

class MyKey2{

    MyKey2(String data){
        this.data = data;
    }

    public String getData(){
        return data;
    }

    private String data = "";
}
