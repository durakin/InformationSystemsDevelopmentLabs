package com.github.durakin.isdlabs.lab6.controller;

import com.github.durakin.isdlabs.lab6.entity.Apparel;
import com.github.durakin.isdlabs.lab6.service.ApparelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Controller
@RequestMapping("/apparels")
public class ApparelController {
    @Autowired
    private ApparelService apparelService;

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

    /*
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putApparel(@PathVariable int id, @RequestBody Apparel apparel) {
    }

    */

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFurniture(@PathVariable int id) {
        apparelService.delete(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Apparel> create(@RequestBody final Apparel newApparel) {
        Apparel apparel = apparelService.findById(apparelService.add(newApparel));
        return new ResponseEntity<>(apparel, HttpStatus.CREATED);
    }
}


