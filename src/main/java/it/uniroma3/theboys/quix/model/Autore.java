package it.uniroma3.theboys.quix.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;


@Entity
public class Autore extends Utente{

    private String biografia;

	@OneToMany(mappedBy = "autore")
    private List<Raccolta> elencoRaccolte;
    
    public String getBiografia() {
        return biografia;
    }
    
    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public List<Raccolta> getElencoRaccolte() {
        return elencoRaccolte;
    }

    public void setElencoRaccolte(List<Raccolta> elencoRaccolte) {
        this.elencoRaccolte = elencoRaccolte;
    }

    /* hashCode e equals generati con riferimento username e email */
    /* Vedi User e scegli soluzione migliore per entrambi */
    
    /* EDIT : dato che Autore estende l'utente, eredita gli equals e hashCode */
}
