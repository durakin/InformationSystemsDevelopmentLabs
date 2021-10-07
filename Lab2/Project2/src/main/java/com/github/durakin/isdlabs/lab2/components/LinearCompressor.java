package com.github.durakin.isdlabs.lab2.components;

public class LinearCompressor implements Compressor {
    private final int power;
    private final int noiseLevel;

    public LinearCompressor(int power, int noiseLevel) {
        this.power = power;
        this.noiseLevel = noiseLevel;
    }

    @Override
    public void startWorking() {
        System.out.println("Compressor starts working loudly");
    }

    @Override
    public void stopWorking() {
        System.out.println("Compressor stopped working with weird echo noises");
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