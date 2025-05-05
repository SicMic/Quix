package it.uniroma3.theboys.quix.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.theboys.quix.model.*;

//classe per le operazioni della persistenza (CRUD: CREATE, READ, UPDATE, DELETE)
public interface RaccoltaRepository extends CrudRepository<Raccolta, Long>{

}