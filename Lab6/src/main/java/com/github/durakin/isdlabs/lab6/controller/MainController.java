package com.github.durakin.isdlabs.lab6.controller;

/*
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
        model.addAttribute("apparels", apparelService.findAll());
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
}
    */

