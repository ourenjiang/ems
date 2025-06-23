package org.example.ems.device.air;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DeviceManagerTest {
    public static void main(String[] args){
        DeviceManager instance = DeviceManager.getInstance();
        instance.start();

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new LinkedList<>();
        Collections.sort(list1);
        Collections.sort(list2);
    }
}
