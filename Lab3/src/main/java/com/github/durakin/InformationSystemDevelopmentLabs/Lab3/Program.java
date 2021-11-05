package com.github.durakin.InformationSystemDevelopmentLabs.Lab3;

import com.github.durakin.InformationSystemDevelopmentLabs.Lab3.components.ApparelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class Program {
    @Autowired
    private static ApparelRepository apparelRepository;
    public Program(ApparelRepository apparelRepository){
        Program.apparelRepository = apparelRepository;
    }
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext(SpringConfig.class);
        /*
        ArrayList<Student> students = new ArrayList<Student>();
        students.add(st);
        Optional<Student> s = studentRepository.findById(1);
        List<Student> lst = studentRepository.findByAvgMarkGreaterThan(4.0);
        studentRepository.saveAll(students);

         */
        return;
    }
}