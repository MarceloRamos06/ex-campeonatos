package com.example.demo.model;

import java.util.ArrayList;

public class Campeonato {

    private ArrayList times;
    private int dataInicial;
    private int dataFinal;
    private int pontos;

    public Campeonato() {

        this.times = new ArrayList();
    }
        public void inserirTime (Time time){
            times.add(time);
        }

        public int getDataInicial () {
            return dataInicial;
        }

        public void setDataInicial ( int dataInicial){
            this.dataInicial = dataInicial;
        }

        public int getDataFinal () {
            return dataFinal;
        }

        public void setDataFinal ( int dataFinal){
            this.dataFinal = dataFinal;
        }

        public int getPontos () {
            return pontos;
        }

        public void setPontos ( int pontos){
            this.pontos = pontos;
        }


    }

