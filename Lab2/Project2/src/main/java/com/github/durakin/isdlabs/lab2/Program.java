package com.github.durakin.isdlabs.lab2;

import com.github.durakin.isdlabs.lab2.components.Fridge;
import com.github.durakin.isdlabs.lab2.components.LinearCompressor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Program {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);
        Fridge fridge1 = (Fridge) context.getBean("fridge");
        Fridge fridge2 = (Fridge) context.getBean("inverterFridge");
        LinearCompressor linearCompressor = (LinearCompressor) context.getBean("linearCompressor2");
        System.out.println(linearCompressor);
        System.out.println(fridge1);
        fridge1.statusOutput();
        System.out.println(fridge2);
        fridge2.statusOutput();
        context.close();
    }
}
