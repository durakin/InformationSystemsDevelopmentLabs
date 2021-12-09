package com.github.durakin.isdlabs.lab7.controller;

import com.github.durakin.isdlabs.lab7.model.ApaprelUpdate;
import com.github.durakin.isdlabs.lab7.entity.Apparel;
import com.github.durakin.isdlabs.lab7.model.Message;
import com.github.durakin.isdlabs.lab7.service.ApparelService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Controller
@RequestMapping("/apparels")
public class ApparelController {
    @Autowired
    private ApparelService apparelService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @ResponseBody
    @GetMapping(value = "/", headers = {"Accept=application/json"})
    public List<Apparel> getApparels() {
        return apparelService.findAll();
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putApparel(@PathVariable int id, @RequestBody ApaprelUpdate apaprelUpdate) {
        apparelService.update(id, apaprelUpdate.getNewInStock(), apaprelUpdate.getNewPrice());
        var edited = apparelService.findById(id);
        if (edited != null) {
            rabbitTemplate.convertAndSend("apparel-queue",
                    new Message("EDIT", java.time.LocalDateTime.now().toString(), edited));
        }
    }

    @ResponseBody
    @GetMapping(value = "/{id}", headers = {"Accept=application/json"})
    public Apparel getApparel(@PathVariable("id") int id) {
        return apparelService.findById(id);
    }

    @GetMapping(value = "/{id}", headers = {"Accept=text/html"})
    public String getStudent(@PathVariable("id") int id, Model model) {
        var apparel = apparelService.findById(id);
        if (apparel != null) {
            model.addAttribute(apparelService.findById(id));
            return "show";
        }
        throw new ResponseStatusException(NOT_FOUND, "Unable to find resource");
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteApparel(@PathVariable int id) {
        var deleted = apparelService.delete(id);
        if (deleted != null) {
            rabbitTemplate.convertAndSend("apparel-queue",
                    new Message("DELETE", java.time.LocalDateTime.now().toString(), deleted));
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Apparel create(@RequestBody final Apparel newApparel, HttpServletResponse response) {
        var createdId = apparelService.add(newApparel);
        response.setHeader("Location", "/apparels/" + createdId);
        var created = apparelService.findById(createdId);
        if (created != null) {
            rabbitTemplate.convertAndSend("apparel-queue",
                    new Message("ADD", java.time.LocalDateTime.now().toString(), created));
        }
        return created;
    }
}
