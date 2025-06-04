package it.uniroma3.theboys.quix.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.theboys.quix.model.Giocatore;


public interface GiocatoreRepository extends CrudRepository<Giocatore, Long>{
    
}
