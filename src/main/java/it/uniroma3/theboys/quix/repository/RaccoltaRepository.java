package it.uniroma3.theboys.quix.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.theboys.quix.model.Raccolta;

//classe per le operazioni della persistenza (CRUD: CREATE, READ, UPDATE, DELETE)
public interface RaccoltaRepository extends CrudRepository<Raccolta, Long>{

    /* Utile per ricerca con filtro ---- da eliminare se si usa la relazione */
    public List<Raccolta> findRaccoltaByEtichettaId(Long etichettaId);

}