package it.uniroma3.theboys.quix.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.uniroma3.theboys.quix.model.Etichetta;

public interface EtichettaRepository extends CrudRepository<Etichetta, Long>{
    
    // public Etichetta findEtichettaByNome(String nome);
    
    @Query(value = "SELECT e.* FROM etichetta e WHERE e.nome = :nomeEtichetta" , nativeQuery = true)
    public Optional<Etichetta> findByNome(@Param("nomeEtichetta") String nome);

}
