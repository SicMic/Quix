package it.uniroma3.theboys.quix.model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

@Entity
public class Giocatore extends Utente {

    @ManyToMany
    private List<Raccolta> elencoRaccolte;

    public List<Raccolta> getElencoRaccolte() {
        return elencoRaccolte;
    }

    public void setElencoRaccolte(List<Raccolta> elencoRaccolte) {
        this.elencoRaccolte = elencoRaccolte;
    }

}
