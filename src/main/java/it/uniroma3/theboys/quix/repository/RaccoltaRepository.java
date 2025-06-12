package it.uniroma3.theboys.quix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.uniroma3.theboys.quix.model.Raccolta;

//classe per le operazioni della persistenza (CRUD: CREATE, READ, UPDATE, DELETE)
public interface RaccoltaRepository extends CrudRepository<Raccolta, Long> {

    /* Utile per ricerca con filtro ---- da eliminare se si usa la relazione */
    public Iterable<Raccolta> findByEtichettaId(Long etichettaId);

    public Iterable<Raccolta> findByAutoreIdAndEtichettaId(Long autoreId, Long etichettaId);

    public Long countByAutoreId(Long autoreId);

    @Query(value = """
            SELECT e.nome, COUNT(r)
            FROM raccolta r
            JOIN etichetta e ON e.id = r.etichetta_id
            WHERE r.autore_id = :autoreId
            GROUP BY e.nome, r.etichetta_id
            ORDER BY COUNT(r) DESC
            """, nativeQuery = true)
    List<Object[]> findEtichettaNomeWithMaxCountByAutore(@Param("autoreId") Long autoreId);

    @Query(value = """
            SELECT e.nome, COUNT(ger.giocatore_id)
            FROM etichetta e
            JOIN raccolta r ON e.id = r.etichetta_id
            JOIN giocatore_elenco_raccolte ger ON ger.elenco_raccolte_id = r.id
            WHERE ger.giocatore_id = :giocatoreId
            GROUP BY e.nome
            ORDER BY COUNT(ger.giocatore_id) DESC
            """, nativeQuery = true)
    List<Object[]> findEtichettaNomeWithMaxCountByGiocatore(@Param("giocatoreId") Long giocatoreId);

    @Query(value = """
            SELECT r.*
            FROM raccolta r
            JOIN etichetta e ON e.id = r.etichetta_id
            WHERE e.nome = :etichetta
            """, nativeQuery = true)
    Iterable<Raccolta> findByEtichettaNome(@Param("etichetta") String nomeEtichetta);

}