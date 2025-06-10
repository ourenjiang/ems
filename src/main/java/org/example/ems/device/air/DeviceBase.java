package org.example.ems.device.air;

/*
* 接口类中特性：
* 变量的访问权限，只能是public static final
* 可以有默认方法和静态方法
*
* */
public interface DeviceBase {
    void start();
    void stop();
    int index();
}
