package com.example.demo.api;
import com.example.demo.model.Time;
import com.example.demo.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController

public class TimeController {
    @Autowired
    private TimeService service;

    @GetMapping("/times")
    public List<Time> listaTimes() { return this.service.listaTimes();}

    @GetMapping("/times/{id}")
    public Time getTime(@PathVariable Integer id) { return this.service.getTime(id); }


    @PostMapping("/times")
    public Time criarTimes(@RequestBody Map<String, String> json) { return this.service.CriarTimes(json);}

    @PostMapping("/times/{id}/campeonatos")
    public Map<String, String> addTime(@PathVariable Integer id, Map<String, Integer> json) {
        return this.service.addTime(id, json);
    }


    }





