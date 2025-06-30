package org.example.learn;

import java.io.Serializable;

public class MyObject implements Cloneable, Comparable<MyObject>, Serializable {
    private int data;

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
//        return super.toString();
        return "rewrite object toString()";
    }

    @Override
    public MyObject clone() {
        try {
            return (MyObject) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public int compareTo(MyObject o) {

//        if(this.data > o.data){
//            return 1;
//        }
//        else if(this.data == o.data){
//            return 0;
//        }
//        else{
//            return -1;
//        }
        return Integer.compare(data, o.data);
    }
}
