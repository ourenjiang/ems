package org.example.ems.device.air.custom;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeviceTest {
    @Test
    public void testIndex() {

        Device device = new Device();
        device.start();
        device.stop();
        assertEquals(5, device.index(), "不等于5啊");
    }
}
