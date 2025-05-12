package it.uniroma3.theboys.quix.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Etichetta {
    
    @Id
    private Long id;

    @Column(unique=true, nullable=false)
    private String nome;
    private String descrizione;

    /* Utile per la ricerca con filtro  --- da rimuovere se si usa la query definita dentro la repository */
    @OneToMany(mappedBy="etichetta")
    private List<Raccolta> elencoRaccolte;

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getDescrizione() {
        return descrizione;
    }
    
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public List<Raccolta> getElencoRaccolte() {
        return elencoRaccolte;
    }

    public void setElencoRaccolte(List<Raccolta> elencoRaccolte) {
        this.elencoRaccolte = elencoRaccolte;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Etichetta other = (Etichetta) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }
    
}
