package com.example.demo.model;


import java.util.Date;

public class Campeonato {
    private int idCamp;
    private String nome;
    private Date dataInicio;
    private Date dataFinal;

    public int getIdCamp() { return idCamp; }

    public void setIdCamp(int idCamp) { this.idCamp = idCamp; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public Date getDataInicio() { return dataInicio; }

    public void setDataInicio(Date dataInicio) { this.dataInicio = dataInicio; }

    public Date getDataFinal() { return dataFinal; }

    public void setDataFinal(Date dataFinal) { this.dataFinal = dataFinal; }

}

