/*
package com.github.durakin.isdlabs.lab5;

import com.github.durakin.isdlabs.lab5.configuration.RootConfiguration;
import com.github.durakin.isdlabs.lab5.service.ApparelService;
import com.github.durakin.isdlabs.lab5.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Program {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RootConfiguration.class);

        var reader = new BufferedReader(new InputStreamReader(System.in));
        var service = context.getBean("userServiceImpl", UserService.class);

        var found = service.FindById(1);
        found.getRoles().forEach(System.out::println);

        context.close();
        System.exit(0);

    }
}

 */
