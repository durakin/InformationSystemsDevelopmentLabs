package com.github.durakin.InformationSystemDevelopmentLabs.Lab3;


import com.github.durakin.InformationSystemDevelopmentLabs.Lab3.components.ApparelDao;
import com.github.durakin.InformationSystemDevelopmentLabs.Lab3.entity.Apparel;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Program {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext(SpringConfig.class);
        ApparelDao apparelDao = context.getBean("apparelDao", ApparelDao.class);
        List<Apparel> apparels = apparelDao.findAll();
        System.out.println(apparels.get(0).toString());
        context.close();

    }
}