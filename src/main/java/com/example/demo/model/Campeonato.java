package com.example.demo.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Campeonato {
    private String nome;
    private Date inicioData;
    private Date finalData;
    private List<Time> fut = new ArrayList<>();

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public Date getInicioData() { return inicioData; }

    public void setInicioData(Date inicioData) { this.inicioData = inicioData; }

    public Date getFinalData() { return finalData; }

    public void setFinalData(Date finalData) { this.finalData = finalData; }

    public List<Time> getFut() { return fut; }

    public void addFut(Time time) { fut.add(time); }

    public static class Ranking implements Comparator<Time> {
        private Campeonato campeonato;

        public Ranking(Campeonato campeonato) { this.campeonato = campeonato; }

        @Override
        public int compare(Time o1, Time o2) {
            return o2.getPontos() .get(campeonato).compareTo(o1.getPontos().get(campeonato));
        }

    }


    }
