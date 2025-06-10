package org.example.ems.device.air.custom;

import org.example.ems.device.air.DeviceBase;

public class Device implements DeviceBase {


    private int age1 = 1;
    private int age2 = 1000;
    private Thread workThread1;
    private Thread workThread2;

    // 为什么要将running修饰为volatile？由于它同时被子线程和外部线程访问，理论是是需要原子性的，
    // volatile是提供线程同步访问的作用吗？
    private volatile boolean running1 = true;
    private volatile boolean running2 = true;

    @Override
    public void start() {
        startThread1();
        startThread2();
    }

    private void startThread1() {
        workThread1 = new Thread(() -> {

            while (running1) {

                synchronized (this) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // sleep调用被外部中断信号打断时，同时该线程的中断状态会被清除；
                        // 为了保持线程的中断状态的一致性，这里需要重新将该线程设置为中断状态，
                        Thread.currentThread().interrupt();
                        break;
                    }

                    System.out.println("thread run1..." + (age1++));
                }
            }

            System.out.println("线程安全终止");
        });
        workThread1.start();
    }

    private void startThread2() {
        workThread2 = new Thread(() -> {

            while (running2) {

                synchronized (this) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        // sleep调用被外部中断信号打断时，同时该线程的中断状态会被清除；
                        // 为了保持线程的中断状态的一致性，这里需要重新将该线程设置为中断状态，
                        Thread.currentThread().interrupt();
                        break;
                    }

                    System.out.println("thread run2..." + (age2++));
                }
            }

            System.out.println("线程安全终止");
        });
        workThread2.start();
    }

    @Override
    public void stop() {
        running1 = false;
        workThread1.interrupt(); // 中断阻塞中的线程

        running2 = false;
        workThread2.interrupt(); // 中断阻塞中的线程
    }

    @Override
    public int index() {
        return 5;
    }
}
