package com.example.demo.service;

import com.example.demo.model.Time;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service

public class Times {

    List<Time> Times = new ArrayList();

    public Time CriarTimes(Map<String, String> json) {
        Time time = new Time();
        time.setNome(json.get("nome"));
        Times.add(time);
        return time;


    }

    public List<Time> getTimes() {
        return Times;
    }

}

