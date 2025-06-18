package it.uniroma3.theboys.quix.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

@Entity
public class Giocatore extends Utente {

    @ManyToMany
    private Set<Raccolta> elencoRaccolte;

    public Set<Raccolta> getElencoRaccolte() {
        return elencoRaccolte;
    }

    public void setElencoRaccolte(Set<Raccolta> elencoRaccolte) {
        this.elencoRaccolte = elencoRaccolte;
    }

}
