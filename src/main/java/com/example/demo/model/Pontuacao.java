package com.example.demo.model;

public class Pontuacao implements Comparable<Pontuacao> {
    private Time time;
    private int pontos;

    public Time getTime() { return time; }

    public void setTime(Time time) { this.time = time; }

    public int getPontos() { return pontos; }

    public void setPontos(Integer pontos) { this.pontos = pontos; }


    @Override
    public int compareTo(Pontuacao o) {
        if(this.pontos == o.getPontos()){
            return 0;
        } else if(this.pontos > o.getPontos()) {
            return 1;
        }
        return -1;

    }
}
