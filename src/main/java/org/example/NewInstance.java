package org.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class NewInstance {
    public void run(){
        // 获取构造方法Integer(int):
        Constructor cons1 = null;
        try {
            cons1 = Integer.class.getConstructor(int.class);

            // 调用构造方法:
            Integer n1 = (Integer) cons1.newInstance(123);
            System.out.println(n1);

            // 获取构造方法Integer(String)
            Constructor cons2 = Integer.class.getConstructor(String.class);
            Integer n2 = (Integer) cons2.newInstance("456");
            System.out.println(n2);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        System.out.println("--------------------------------------------\n");
    }
}
