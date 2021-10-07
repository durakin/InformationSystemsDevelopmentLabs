package com.github.durakin.isdlabs.lab2;

import com.github.durakin.isdlabs.lab2.components.CompressorFactory;
import com.github.durakin.isdlabs.lab2.components.Fridge;
import com.github.durakin.isdlabs.lab2.components.InverterCompressor;
import com.github.durakin.isdlabs.lab2.components.LinearCompressor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.github.durakin.isdlabs.lab2.components")
public class Config {

    @Bean (name="linearCompressor1", initMethod = "startWorking", destroyMethod = "stopWorking")
    public LinearCompressor linearCompressor1(){
        return (LinearCompressor) CompressorFactory.getCompressor("LiNeAr", 1488, 228);
    }

    @Bean (initMethod = "startWorking", destroyMethod = "stopWorking")
    public LinearCompressor linearCompressor2(){
        return new LinearCompressor(1337, 322);
    }

    @Bean (initMethod = "startWorking", destroyMethod = "stopWorking")
    public InverterCompressor inverterCompressor(){
        return (InverterCompressor) CompressorFactory.getCompressor("INVERTER", 40000, 100500);
    }

    @Bean ("inverterFridge")
    public Fridge inverterFridge(){
        return new Fridge(inverterCompressor());
    }

}
