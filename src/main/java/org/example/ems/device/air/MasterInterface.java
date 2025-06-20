package org.example.ems.device.air;

public interface MasterInterface {
    void start();

    // 读-线圈输出状态
    int[] readCoilRegisters(int devAddr, int regAddr, int regNum);

    // 读-离散输入状态
    int[] readDiscreteInputRegisters(int devAddr, int regAddr, int regNum);

    // 读-保持寄存器
    int[] readHoldRegisters(int devAddr, int regAddr, int regNum);

    // 读-输入寄存器
    int[] readInputRegisters(int devAddr, int regAddr, int regNum);

    // 写-单个线圈
    void writeSingleCoil(int devAddr, int regAddr, int regData);

    // 写单个寄存器
    void writeSingleRegister(int devAddr, int regAddr, int regData);
}
