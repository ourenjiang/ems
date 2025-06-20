package org.example.ems.device.air.custom;

import org.example.ems.device.air.MasterInterface;

public class Master implements MasterInterface {
    @Override
    public void start() {

    }

    @Override
    public int[] readCoilRegisters(int devAddr, int regAddr, int regNum) {
        return new int[0];
    }

    @Override
    public int[] readDiscreteInputRegisters(int devAddr, int regAddr, int regNum) {
        return new int[0];
    }

    @Override
    public int[] readHoldRegisters(int devAddr, int regAddr, int regNum) {
        return new int[0];
    }

    @Override
    public int[] readInputRegisters(int devAddr, int regAddr, int regNum) {
        return new int[0];
    }

    @Override
    public void writeSingleCoil(int devAddr, int regAddr, int regData) {

    }

    @Override
    public void writeSingleRegister(int devAddr, int regAddr, int regData) {

    }
}
