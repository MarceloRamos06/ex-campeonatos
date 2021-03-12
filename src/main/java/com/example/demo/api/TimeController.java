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

    //listar todos os times criados
    @GetMapping("/times")
    public List<Time> listarTimes() { return this.service.getTimes();}

    //buscar times pelo seu id
    @GetMapping("/times/{id}")
    public Time mostraTime(@PathVariable Integer id) { return this.service.mostraTime(id); }

    //criar os times
    @PostMapping("/times")
    public Time criarTime (@RequestBody Map<String, String> json) { return this.service.criarTimes(json);}

    }
