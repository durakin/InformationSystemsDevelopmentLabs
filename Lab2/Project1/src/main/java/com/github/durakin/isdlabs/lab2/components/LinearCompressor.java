package com.github.durakin.isdlabs.lab2.components;

public class LinearCompressor implements Compressor {
    private final int power;
    private int noiseLevel;

    public LinearCompressor(int power, int noiseLevel) {
        this.power = power;
        this.noiseLevel = noiseLevel;
    }

    public void setNoiseLevel(int noiseLevel) {
        this.noiseLevel = noiseLevel;
    }

    @Override
    public String work() {
        return "Compressor works loudly growling";
    }

    @Override
    public String toString() {
        return "Linear compressor with power of " + power + " and noise level of " + noiseLevel;
    }
}