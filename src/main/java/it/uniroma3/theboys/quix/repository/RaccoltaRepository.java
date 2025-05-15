package it.uniroma3.theboys.quix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.uniroma3.theboys.quix.model.Raccolta;

//classe per le operazioni della persistenza (CRUD: CREATE, READ, UPDATE, DELETE)
public interface RaccoltaRepository extends CrudRepository<Raccolta, Long>{

    /* Utile per ricerca con filtro ---- da eliminare se si usa la relazione */
    public Iterable<Raccolta> findByEtichettaId(Long etichettaId);

    public Iterable<Raccolta> findByAutoreIdAndEtichettaId(Long autoreId, Long etichettaId);

    public Long countByAutoreId(Long autoreId);

    @Query(value = """
    SELECT r.etichetta.nome, COUNT(r)
    FROM raccolta r
    JOIN etichetta e ON e.id = r.etichetta_id
    WHERE r.autore.id = :autoreId
    GROUP BY r.etichetta.id
    ORDER BY COUNT(r) DESC
    """, nativeQuery = true)
    List<Object[]> findEtichettaNomeWithMaxCountByAutore(@Param("autoreId") Long autoreId);


}