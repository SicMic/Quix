package it.uniroma3.theboys.quix.service;

import java.time.LocalDateTime;

public class ClassificaDTO {
    private String username;
    private Integer punteggio;
    private LocalDateTime data;


    public ClassificaDTO(String username, Integer punteggio, LocalDateTime data) {
        this.username = username;
        this.punteggio = punteggio;
        this.data = data;
    }

    public String getUsername() {
        return username;
    }

    public Integer getPunteggio() {
        return punteggio;
    }

    public LocalDateTime getData() {
        return data;
    }
}
