package it.uniroma3.theboys.quix.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

@Entity
public class Giocatore extends Utente {

    @ManyToMany
    private Set<Raccolta> elencoRaccolte;

    private Long punteggio = new Long(0);

    public Set<Raccolta> getElencoRaccolte() {
        return elencoRaccolte;
    }

    // public Giocatore(){
    //     this.punteggio = new Long(0);
    // }

    public void setElencoRaccolte(Set<Raccolta> elencoRaccolte) {
        this.elencoRaccolte = elencoRaccolte;
    }

    public Long getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(Long punteggio) {
        this.punteggio = punteggio;
    }
    
    public void sommaPunteggio(Long punteggio) {
        this.punteggio += punteggio;
    }
    
}
