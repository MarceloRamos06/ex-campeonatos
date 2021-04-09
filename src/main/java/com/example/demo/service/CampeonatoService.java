package com.example.demo.service;

import com.example.demo.model.Campeonato;
import com.example.demo.model.Pontuacao;
import com.example.demo.model.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class CampeonatoService {
    //formato de data
    SimpleDateFormat formatoData = new SimpleDateFormat("dd-MM-yyyy");

    @Autowired
    private TimeService service;

    //criacao de uma lista vazia
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

    public Campeonato inserirTime(Integer id, Map<String, String> json) {
        Campeonato camp = campeonatos.get(id);
        Time timep = this.service.mostraTime(Integer.parseInt(json.get("idTime")));
        Pontuacao pont = new Pontuacao();
        pont.setTime(timep);
        pont.setPontos(service.numPon());
        camp.getListaPontuacao().add(pont);
        Collections.sort(camp.getListaPontuacao(),Collections.reverseOrder());
        //timep.setPontosTime(service.numPon());
        return camp;

    }



    //contador
    Integer seqC = 0;
    private Integer seqCamp() {
        return seqC ++;
    }

    //faz busca pela id
    public Campeonato mostraCamp(Integer id) { return this.campeonatos.get(id); }

}
