package com.github.durakin.isdlabs.lab5.controller;

import com.github.durakin.isdlabs.lab5.entity.User;
import com.github.durakin.isdlabs.lab5.form.UserForm;
import com.github.durakin.isdlabs.lab5.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    public final PasswordEncoder passwordEncoder;
    private final UserRepository repository;

    public RegistrationController(@Qualifier("userRepository") UserRepository repository, @Qualifier("passwordEncoder") PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String showAddShoesForm(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "registration";
    }

    @PostMapping
    public String saveUserToDb(@Valid UserForm userForm, BindingResult bindingResult, Model model) {
        try {
            User newUser = new User(userForm.getUsername(), passwordEncoder.encode(userForm.getPassword()));
            repository.save(newUser);
            System.out.println("New user created");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/";
    }
}

