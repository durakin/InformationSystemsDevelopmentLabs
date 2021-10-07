package com.github.durakin.isdlabs.lab2.components;

public class CompressorFactory {
    public static Compressor getCompressor(String type, int power, int spec) {
        if ("Inverter".equalsIgnoreCase(type)) {
            return new InverterCompressor(power, spec);
        }
        if ("Linear".equalsIgnoreCase(type)) {
            return new LinearCompressor(power, spec);
        }
        return null;
    }
}
