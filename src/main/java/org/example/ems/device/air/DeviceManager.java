package org.example.ems.device.air;

import org.example.ems.device.air.langji.Device;
import org.example.ems.utils.ConfigLoader;

import javax.sound.midi.SysexMessage;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class DeviceManager {
    private static DeviceManager instance = new DeviceManager();
    ArrayList<DeviceInterface> deviceInterfaces = new ArrayList<>();

    private DeviceManager() {
        loadConfigure();
    }

    public static DeviceManager getInstance() {
        return instance;
    }

    private ArrayList<DeviceInterface> airInterfaces = new ArrayList<>();

    public void start() {
        for (DeviceInterface airInterface : airInterfaces) {
            airInterface.start();
        }
    }

    private DeviceInterface createDevice(String type, int index, int modbusAddr, MasterInterface masterInterface){
        if(type.equals("Custom")){
            return new org.example.ems.device.air.custom.Device();
        }
        else if(type.equals("Langji")) {
            return new org.example.ems.device.air.langji.Device();
        }
        else {
            // 默认返回Custom版本
            return new org.example.ems.device.air.custom.Device();
        }
    }

    private void loadConfigure(){
        ConfigLoader.getConfig("application.yml");
//        deviceInterfaces

        Map<String, Object> airConfigure = ConfigLoader.getValue("air");

        Map<String, MasterInterface> masterInterfaceMap;

        int deviceIndex = 0;

        assert airConfigure != null;
        Object devices = airConfigure.get("devices");
        ArrayList<LinkedHashMap<String, Object>> devices2 = (ArrayList<LinkedHashMap<String, Object>>) devices;
        for(Object item : devices2){
            System.out.println(item);
        }
    }
}
