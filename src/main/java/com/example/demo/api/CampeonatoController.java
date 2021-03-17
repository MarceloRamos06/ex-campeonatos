package com.example.demo.api;

import com.example.demo.model.Campeonato;
import com.example.demo.service.CampeonatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/campeonato")
public class CampeonatoController {
    @Autowired
    private CampeonatoService service;

    //busca os campeonatos
    @GetMapping
    public List<Campeonato> listaCampeonatos() { return this.service.listaCampeonatos(); }

      // listaCampeonatos()

    //busca campeonato pela id
    @GetMapping("/{id}")
    public Campeonato mostraCamp(@PathVariable Integer id) { return this.service.mostraCamp(id); }

    //criar os campeonatos
    @PostMapping
    public Campeonato criarCampeonato(@RequestBody Map<String, String> json) throws ParseException {
        return this.service.criarCampeonato(json); }

    @PostMapping("/{id}/time")
    public Campeonato inserirTime(@PathVariable Integer id,@RequestBody Map<String, String> json) throws ParseException {
    return this.service.inserirTime(id, json); }
}





//localhost:8080/campeonatos

/* {
    "nome": "Libertadores",
    "inicio": "20-02-2020",
    "final": "23-11-2020"
    }
 */

