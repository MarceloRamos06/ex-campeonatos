package com.example.demo.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
@Table(name = "campeonato")
@Entity(name = "Campeonato")
public class Campeonato {

    @Id
    @Column(name = "id")
    private int idCamp;

    @Column
    private String nome;

    @Column(name = "data_inicio")
    private Date dataInicio;

    @Column
    private Date dataFinal;

    // Ignora salvar no banco de dados


    private ArrayList<Pontuacao> listaPontuacao = new ArrayList<>();

    //private int nome;
    // public void setNome(String nome)  { this.nome = nome; }


}


