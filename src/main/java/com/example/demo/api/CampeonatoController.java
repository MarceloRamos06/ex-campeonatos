package com.example.demo.api;

import com.example.demo.model.Campeonato;
import com.example.demo.service.CampeonatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
public class CampeonatoController {
    @Autowired
    private CampeonatoService service;

    @GetMapping("/campeonatos")
    public List<Campeonato> listaCampeonatos() {
        return this.service.listaCampeonatos();
    }

    @GetMapping("/campeonatos/{id}")
    public Campeonato getCampeonato(@PathVariable("id") Integer id) {
        return this.service.getCampeonato(id);
    }

    @GetMapping("/campeonatos/{id}/tabela")
    public List<Map<String, Integer>> getRanking(@PathVariable Integer id) {
        return this.service.getRanking(id);
    }

    @PostMapping("/campeonatos")
    public Campeonato criarCampeonato(@RequestBody Map<String, String> json) throws ParseException {
        return this.service.criarCampeonato(json);
    }

    @PostMapping("/campeonatos/{id}/times")
    public Map<String, String> addTime(@PathVariable Integer id, @RequestBody Map<String, Integer> json) {
        return this.service.addTime(id, json);
    }
}
