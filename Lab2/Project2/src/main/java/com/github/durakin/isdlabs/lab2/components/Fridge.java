package com.github.durakin.isdlabs.lab2.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Fridge {

    private Compressor compressor;

    @Autowired
    public Fridge(@Qualifier("linearCompressor1") Compressor compressor) {
        this.compressor = compressor;
    }

    @Override
    public String toString() {
        return "Fridge, equipped with compressor: " + compressor;
    }

    public void statusOutput() {
        System.out.println(this.compressor.work());
    }

}
