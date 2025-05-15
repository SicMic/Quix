package it.uniroma3.theboys.quix.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.theboys.quix.model.Utente;


public interface UtenteRepository extends CrudRepository<Utente, Long>{

    public Optional<Utente> findByUsername(String username);
    
}
