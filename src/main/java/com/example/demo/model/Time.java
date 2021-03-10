package com.example.demo.model;

import java.util.HashMap;
import java.util.Map;

public class Time {
    private String nome;
    private Map<Campeonato, Integer> pontos = new HashMap<>();


    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public Map<Campeonato, Integer> getPontos() { return pontos;}

    public Integer getPontosC(Campeonato campeonato) { return this.pontos.get(campeonato);}

    public void addTime(Campeonato campeonato) { this.pontos.put(campeonato, 0);}

    public void addTime(Campeonato campeonato, Integer pontos) { this.pontos.put(campeonato, pontos);}


    }



