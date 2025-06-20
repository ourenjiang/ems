package org.example.ems.device.air.langji;

import java.util.ArrayList;

public class Collector {
    private ArrayList<Runnable> runList = new ArrayList<>();
    private int runListIndex = 0;

    Collector(){
        runList.add(this::doFrame_10035_10058);
        runList.add(org.example.ems.device.air.langji.Collector::doFrame_10035_10058_2);
        runList.add(this::doFrame_30001_30025);

        for(Runnable runnable : runList){
            runnable.run();
        }
    }

    public void run() {
        if(runList.isEmpty()){
            return;
        }

        while(true){
            // 执行当前位置
            Runnable runnable = runList.get(runListIndex);
            runnable.run();

            // 跳转到下一位置，为下次执行提前作准备
            runListIndex = (runListIndex+1) % runList.size();

            // 主动延时
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void doFrame_10035_10058(){
        System.out.println("call doFrame_10035_10058");
    }
    private static void doFrame_10035_10058_2(){
        System.out.println("call doFrame_10035_10058_2");
    }

    private void doFrame_30001_30025(){
        System.out.println("call doFrame_30001_30025");
    }
}
