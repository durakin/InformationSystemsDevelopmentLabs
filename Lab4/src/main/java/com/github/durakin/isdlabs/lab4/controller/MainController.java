package com.github.durakin.isdlabs.lab4.controller;

import com.github.durakin.isdlabs.lab4.entity.Apparel;
import com.github.durakin.isdlabs.lab4.service.ApparelService;
import com.github.durakin.isdlabs.lab4.service.impl.ApparelServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@Controller
public @Data
class MainController {
    private final ApplicationContext context;
    private final ApparelServiceImpl apparelService;

    @Autowired
    public MainController(ApplicationContext applicationContext) {
        this.context = applicationContext;
        this.apparelService = context.getBean("apparelServiceImpl", ApparelServiceImpl.class);
    }

    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("apparel", apparelService.findAll());
        return "home";
    }

    @GetMapping("/add")
    public String addPage(Model model) {
        model.addAttribute("apparel", new Apparel());
        return "add";
    }
    @PostMapping("/add")
    public String addFormHandler(@ModelAttribute("apparel") Apparel apparel) {
        apparelService.add(apparel);
        return "redirect:/";
    }

    /*
    @GetMapping("/edit")
    public String editPage(Model model) {
        model.addAttribute("apparel", new Apparel());
        return "edit";
    }

    @PostMapping("/edit")
    public String editFormHandler(
            @ModelAttribute @Valid Apparel apparel,
            BindingResult bindingResult,
            @RequestParam("id") Integer id) {
        System.out.println(bindingResult);
        if (bindingResult.hasErrors())
            return "redirect:/edit";

        apparelService.update(id, stationery);
        return "redirect:/";
    }
    */

    @GetMapping("/delete")
    public String deletePage() {
        return "delete";
    }
    @PostMapping("/delete")
    public String deleteFormHandler( @RequestParam("id") Integer id ) {
        apparelService.delete(id);
        return "redirect:/";
    }

    /*
    @GetMapping("/show_criteria")
    public String criteriaPage() {
        return "criteria";
    }
    @PostMapping("/show_criteria")
    public String criteriaFormHandler( @RequestParam String manufacturer, ModelMap model ) {
        model.addAttribute("stationery", stationeryService.getByManufacturer(manufacturer));
        return "criteria_result";
    }
    */
}
