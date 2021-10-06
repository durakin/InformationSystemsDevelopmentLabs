package com.github.durakin.isdlabs.lab2.components;

public class Fridge {
    private final Compressor compressor;

    public Fridge(Compressor compressor) {
        this.compressor = compressor;
    }

    @Override
    public String toString() {
        return "Fridge, equipped with compressor: " + compressor;
    }

    public void statusOutput() { System.out.println(this.compressor.work());}

}
