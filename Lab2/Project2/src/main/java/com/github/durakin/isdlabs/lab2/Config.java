package com.github.durakin.isdlabs.lab2;

import com.github.durakin.isdlabs.lab2.components.CompressorFactory;
import com.github.durakin.isdlabs.lab2.components.Fridge;
import com.github.durakin.isdlabs.lab2.components.InverterCompressor;
import com.github.durakin.isdlabs.lab2.components.LinearCompressor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.github.durakin.isdlabs.lab2.components")
@PropertySource("classpath:linearCompressor.properties")
public class Config {

    @Bean (name="linearCompressor1", initMethod = "startWorking", destroyMethod = "stopWorking")
    public LinearCompressor linearCompressor1(){
        return (LinearCompressor) CompressorFactory.getCompressor("LiNeAr", 1488, 228);
    }

    @Value("${compressorNoise}")
    private int noise;
    @Bean (initMethod = "startWorking", destroyMethod = "stopWorking")
    public LinearCompressor linearCompressor2(){
        LinearCompressor result = new LinearCompressor(1337, 0);
        result.setNoiseLevel(noise);
        return result;
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
