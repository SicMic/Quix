package it.uniroma3.theboys.quix.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Autore extends Utente {

    @Column(length = 500)
    private String biografia;

    @Column(length = 500)
    private String urlImage;

    @OneToMany(mappedBy = "autore", cascade = CascadeType.REFRESH)
    private List<Raccolta> elencoRaccolte;

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Iterable<Raccolta> getElencoRaccolte() {
        return elencoRaccolte;
    }

    public void setElencoRaccolte(List<Raccolta> elencoRaccolte) {
        this.elencoRaccolte = elencoRaccolte;
    }

}
