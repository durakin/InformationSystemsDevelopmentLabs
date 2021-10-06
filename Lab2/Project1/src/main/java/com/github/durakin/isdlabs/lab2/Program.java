package com.github.durakin.isdlabs.lab2;

import com.github.durakin.isdlabs.lab2.components.Fridge;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext("applicationContext.xml");
        Fridge linearFridge = context.getBean("linearFridgeBean", Fridge.class);
        Fridge inverterFridge = context.getBean("inverterFridgeBean", Fridge.class);
        System.out.println(linearFridge);
        linearFridge.statusOutput();
        System.out.println(inverterFridge);
        inverterFridge.statusOutput();

        context.close();
    }
}
