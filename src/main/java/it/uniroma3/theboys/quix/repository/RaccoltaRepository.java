package it.uniroma3.theboys.quix.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.theboys.quix.model.Raccolta;

//classe per le operazioni della persistenza (CRUD: CREATE, READ, UPDATE, DELETE)
public interface RaccoltaRepository extends CrudRepository<Raccolta, Long>{

    /* Utile per ricerca con filtro ---- da eliminare se si usa la relazione */
    public Iterable<Raccolta> findByEtichettaId(Long etichettaId);

    public Iterable<Raccolta> findByAutoreIdAndEtichettaId(Long autoreId, Long etichettaId);
}