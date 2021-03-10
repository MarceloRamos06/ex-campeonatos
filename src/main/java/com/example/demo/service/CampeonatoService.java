package com.example.demo.service;

import com.example.demo.model.Campeonato;
import com.example.demo.model.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service

public class CampeonatoService {
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", new Locale("pt", "BR"));
    @Autowired
    private TimeService timeService;
    private List<Campeonato> campeonatos = new ArrayList<>();

    public List<Campeonato> listaCampeonatos() {
        return this.campeonatos;

    }

    public Campeonato getCampeonato(Integer id) {
        return this.campeonatos.get(id);
    }

    public Campeonato criarCampeonato(Map<String, String> params) throws ParseException {
        Campeonato newCampeonato = new Campeonato();
        newCampeonato.setNome(params.get("nome"));
        newCampeonato.setInicioData(dateFormat.parse(params.get("inicio")));
        newCampeonato.setFinalData(dateFormat.parse(params.get("fim")));
        this.campeonatos.add(newCampeonato);
        return newCampeonato;
    }

    public Map<String,String> addTime(Integer id, Map<String, Integer> params) {
    Map<String, String> responda = new HashMap<>();
    Campeonato campeonato = this.campeonatos.get(id);
    Integer idTime = params.get("idTime");

        if (Objects.nonNull(campeonato) && Objects.nonNull(idTime)) {
            Time time;
            Integer pontos = params.get("pontos");
            if (Objects.nonNull(pontos)) {
                time = this.timeService.addTime(idTime, campeonato, pontos);
            } else {
                time = this.timeService.addTime(idTime, campeonato);
            }
            campeonato.addFut(time);
            responda.put("mensagem", "sucesso.");
            return responda;
        }
        responda.put("mensagem", "falhou.");
        responda.put("mensagem", String.format("%s não pode ser nulo.", Objects.isNull(campeonato) ? "Campeonato" : "Time"));
        return responda;
    }

    public List<Map<String, Integer>> getRanking(Integer id) {
        List<Map<String, Integer>> ranking = new ArrayList<>();
        Campeonato campeonatoAtual = this.campeonatos.get(id);
        List<Time> fut = campeonatoAtual.getFut();

        fut.sort(new Campeonato.Ranking(campeonatoAtual));
        fut.forEach(Time -> {
            Map<String, Integer> pontosTime = new HashMap<>();
            pontosTime.put(Time.getNome(), Time.getPontosC(campeonatoAtual));
            ranking.add(pontosTime);
        });
        return ranking;
    }
}
