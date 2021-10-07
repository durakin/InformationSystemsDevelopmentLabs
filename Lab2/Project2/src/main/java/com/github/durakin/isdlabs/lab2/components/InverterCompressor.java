package com.github.durakin.isdlabs.lab2.components;

public class InverterCompressor implements Compressor {
    private final int power;
    private final int vibration;

    public InverterCompressor(int power, int vibration) {
        this.power = power;
        this.vibration = vibration;
    }

    @Override
    public void startWorking() {
        System.out.println("Compressor starts working quietly");
    }

    @Override
    public void stopWorking() {
        System.out.println("Compressor stopped working without any sound");
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
