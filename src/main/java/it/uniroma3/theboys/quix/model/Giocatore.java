package it.uniroma3.theboys.quix.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

@Entity
public class Giocatore extends Utente {

    @ManyToMany
    private Set<Raccolta> elencoRaccolte;

    private Integer punteggio;

    public Set<Raccolta> getElencoRaccolte() {
        return elencoRaccolte;
    }

    public Giocatore(){
        this.punteggio = new Integer(0);
    }

    public void setElencoRaccolte(Set<Raccolta> elencoRaccolte) {
        this.elencoRaccolte = elencoRaccolte;
    }

    public Integer getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(Integer punteggio) {
        this.punteggio = punteggio;
    }
    
    public void sommaPunteggio(Integer punteggio) {
        this.punteggio += punteggio;
    }
    
}
