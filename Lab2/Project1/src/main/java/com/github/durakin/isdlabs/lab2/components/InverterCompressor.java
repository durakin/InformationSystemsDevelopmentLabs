package com.github.durakin.isdlabs.lab2.components;

public class InverterCompressor implements Compressor {
    private final int power;
    private int vibration;

    public InverterCompressor(int power) {
        this.power = power;
    }

    public InverterCompressor(int power, int vibration) {
        this.power = power;
        this.vibration = vibration;
    }

    public void setVibration(int vibration) {
        this.vibration = vibration;
    }

    @Override
    public String work() {
        return "Compressor works quite, but vibrates";
    }

    @Override
    public String toString() {
        return "Inverter compressor with power of " + power + " and vibration of " + vibration;
    }
}
