package org.example.ems.device.air;

public interface ControllerInterface {
    // 关机
    void setPoweroff();

    // 开机
    void setPoweron();

    // 启动制冷温度
    void setCoolStartTemperature(float temperature);

    // 关闭制冷温度
    void setCoolStopTemperature(float temperature);

    // 启动制热温度
    void setHeatStartTemperature(float temperature);

    // 停止制热温度
    void setHeatStopTemperature(float temperature);

    // 启动除湿湿度
    void setCsStartHumidity(float humidity);

    // 停止除湿湿度
    void setCsStopHumidity(float humidity);

    // 模式(制热)
    void setModeHeat(boolean on);

    // 模式(制冷)
    void setModeCool(boolean on);
}
