package com.example.demo.api;

import com.example.demo.model.Campeonato;
import com.example.demo.service.CampeonatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController

public class CampeonatoController {
    @Autowired
    private CampeonatoService service;

    @GetMapping("/campeonatos")
    public List<Campeonato> listaCampeonatos() { return this.service.listaCampeonatos(); }

    @PostMapping("/campeonatos")
    public Campeonato criarCampeonato(@RequestBody Map<String, String> json) throws ParseException {
        return this.service.criarCampeonato(json);
    }


}
