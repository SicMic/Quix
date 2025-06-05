package it.uniroma3.theboys.quix.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;

@Entity
public class Autore extends Utente {

    @Column(length = 500)
    private String biografia;

    @OneToMany(mappedBy = "autore", cascade = CascadeType.REFRESH)
    @OrderBy("dataCreazione DESC")
    private List<Raccolta> elencoRaccolte;

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public List<Raccolta> getElencoRaccolte() {
        if (this.elencoRaccolte == null)
            return new ArrayList<>();
        return elencoRaccolte;
    }

    public void setElencoRaccolte(List<Raccolta> elencoRaccolte) {
        this.elencoRaccolte = elencoRaccolte;
    }

}
