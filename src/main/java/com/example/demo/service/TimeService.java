package com.example.demo.service;

import com.example.demo.model.Campeonato;
import com.example.demo.model.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service

public class TimeService {
    @Autowired
    private CampeonatoService campeonatoService;
    private List<Time> times = new ArrayList();
    public List<Time> listaTimes() {
        return this.times;
    }

    public Time getTime(Integer id) {
        return this.times.get(id);
    }

    public Time CriarTimes(Map<String, String> json) {
        Time time = new Time();
        time.setId(sequencialNumber());
        time.setNome(json.get("nome"));
        times.add(time);
        return time;

    }

    public Map<String, String> addTime(Integer id, Map<String, Integer> json){
        Map<String, String> responde = new HashMap<>();
        Campeonato campeonato = this.campeonatoService.getCampeonato(json.get("idCampeonato"));

        if(Objects.nonNull(campeonato)) {
            Time time;
            Integer pontos = json.get("Pontos");
            if (Objects.nonNull(pontos)) {
                time = this.addTime(id, campeonato, pontos);
            } else {
                time = this.addTime(id, campeonato);
            }
            campeonato.addFut(time);
            responde.put("mensagem", "Sucesso");
            return responde;
        }
        responde.put("mensagem", "falhou");
        responde.put("mensagem", "Campeonato não pode ser nulo");
        return responde;
    }

    public Time addTime(Integer id, Campeonato campeonato) {
        Time time = this.times.get(id);
        return time;
    }

    public Time addTime(Integer id, Campeonato campeonato, Integer pontos) {
        Time time = this.times.get(id);
        time.addTime(campeonato, pontos);
        return time;
    }

    public List<Time> getTimesOgetCampeonato(Integer id) {
        Campeonato campeonato = this.campeonatoService.getCampeonato(id);
        return this.times.stream()
                .filter(time -> time.getPontos().keySet().contains(campeonato))
                .collect(Collectors.toList());
    }

    Integer seqNumber = 0;
    private Integer sequencialNumber(){
        return seqNumber ++;
    }
}







