package it.uniroma3.theboys.quix.model;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

@Entity
public class Giocatore extends Utente {

    @Column(length = 500)
    private String urlImage;

    @ManyToMany
    private List<Raccolta> elencoRaccolte;

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public List<Raccolta> getElencoRaccolte() {
        return elencoRaccolte;
    }

    public void setElencoRaccolte(List<Raccolta> elencoRaccolte) {
        this.elencoRaccolte = elencoRaccolte;
    }

}
