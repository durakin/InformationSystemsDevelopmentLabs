package com.github.durakin.isdlabs.lab5.controller;

import com.github.durakin.isdlabs.lab5.service.impl.ApparelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
    private final ApplicationContext context;
    private final ApparelServiceImpl apparelService;

    @Autowired
    public IndexController(ApplicationContext applicationContext) {
        this.context = applicationContext;
        this.apparelService = context.getBean("apparelServiceImpl", ApparelServiceImpl.class);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showHomePage(Model model) {
        model.addAttribute("count", (long) apparelService.findAll().size());
        return "index";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String privateHome() {
        return "private_page";
    }
}

