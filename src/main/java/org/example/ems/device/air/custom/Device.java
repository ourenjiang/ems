package org.example.ems.device.air.custom;

import org.example.ems.device.air.DeviceBase;

import java.util.Timer;
import java.util.TimerTask;

public class Device implements DeviceBase {

    Timer timer = new Timer();
    private int age = 1;
    private Thread workThread;

    // 为什么要将running修饰为volatile？由于它同时被子线程和外部线程访问，理论是是需要原子性的，
    // volatile是提供线程同步访问的作用吗？
    private volatile boolean running = true;

    @Override
    public void start() {
        timer.scheduleAtFixedRate(new MyTask(), 0, 1000);
//        workThread = new Thread(() -> {
//
//            while (running) {
//
//                synchronized (this) {
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        // sleep调用被外部中断信号打断时，同时该线程的中断状态会被清除；
//                        // 为了保持线程的中断状态的一致性，这里需要重新将该线程设置为中断状态，
//                        Thread.currentThread().interrupt();
//                        break;
//                    }
//
//                    System.out.println("thread run1..." + (age++));
//                }
//            }
//
//            System.out.println("线程安全终止");
//        });
//        workThread.start();
    }

    class MyTask extends TimerTask{

        @Override
        public void run() {
            System.out.println("call MyTask run!");
        }
    }

    @Override
    public void stop() {
        running = false;
        workThread.interrupt(); // 中断阻塞中的线程
    }

    @Override
    public int index() {
        return 5;
    }
}
