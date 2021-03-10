package com.example.demo.api;
import com.example.demo.model.Time;
import com.example.demo.service.Times;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController

public class TimeController {
    @Autowired
    private Times service;

    @GetMapping("/times")
    public List<Time> listTimes() { return this.service.getTimes();}

    @PostMapping("/times")
    public Time criarTimes(@RequestBody Map<String, String> json) { return this.service.CriarTimes(json);}


    }


