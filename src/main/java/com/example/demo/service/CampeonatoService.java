package com.example.demo.service;

import com.example.demo.model.Campeonato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service

public class CampeonatoService {

    //formato de data e hora
    SimpleDateFormat formatoData = new SimpleDateFormat("dd-MM-yyyy");
    @Autowired

    //criacao de uma lista vazia
    private TimeService timeService;
    private List<Campeonato> campeonatos = new ArrayList<>();

    public List<Campeonato> listaCampeonatos() {
        return this.campeonatos;
    }

    //criaçao dos campeonatos(id, nome, inicio, final)
    public Campeonato criarCampeonato(Map<String, String> json) throws ParseException {
        Campeonato novoCamp = new Campeonato();
        novoCamp.setIdCamp(seqCamp());
        novoCamp.setNome(json.get("nome"));
        novoCamp.setDataInicio(formatoData.parse(json.get("inicio")));
        novoCamp.setDataFinal(formatoData.parse(json.get("final")));
        this.campeonatos.add(novoCamp);
        return novoCamp;

    }

    //contador
    Integer seqC = 0;
    private Integer seqCamp() {
        return seqC ++;
    }

    //faz busca pela id
    public Campeonato mostraCamp(Integer id) { return this.campeonatos.get(id); }

}
