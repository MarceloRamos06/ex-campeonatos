package com.example.demo.service;
import com.example.demo.model.Time;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;


@Service

public class TimeService {

    //criação da lista vazia

    private List<Time> times = new ArrayList<>();
    public List<Time> getTimes (){ return this.times;
    }


    //criação dos times(id, nome e pontuação aleatoria)
    public Time criarTimes (Map<String, String> json){
        Time getTimes = new Time();
        getTimes.setPontosTime(numPon());
        getTimes.setIdTime(seqTime());
        getTimes.setNome(json.get("nome"));
        times.add(getTimes);
        return getTimes;

    }
    //contador
        Integer seqT = 0;
    private Integer seqTime() {
        return seqT ++;
    }

    //random potuação time
    Random aleatorio = new Random();
    private Integer numPon() {
    Integer numP = aleatorio.nextInt(40);
        return numP;
    }

    //faz atribuição da id
    public Time mostraTime(Integer id) {
        return this.times.get(id);
    }



}
