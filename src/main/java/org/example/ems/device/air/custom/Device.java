package org.example.ems.device.air.custom;

import org.example.ems.device.air.DeviceBase;

import java.util.Timer;
import java.util.TimerTask;

public class Device implements DeviceBase {
    Timer timer = new Timer();

    @Override
    public void start() {
        timer.scheduleAtFixedRate(new MyTask(), 0, 1000);
    }

    static class MyTask extends TimerTask{

        @Override
        public void run() {
            System.out.println("call MyTask run!");
        }
    }

    @Override
    public void stop() {
        timer.cancel();
    }

    @Override
    public int index() {
        return 5;
    }
}
