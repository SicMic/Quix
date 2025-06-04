package it.uniroma3.theboys.quix.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.theboys.quix.model.Autore;

public interface AutoreRepository extends CrudRepository<Autore, Long>{
    
}
