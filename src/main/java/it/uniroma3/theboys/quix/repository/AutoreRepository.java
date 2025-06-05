package it.uniroma3.theboys.quix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.uniroma3.theboys.quix.model.Autore;

public interface AutoreRepository extends CrudRepository<Autore, Long>{

    @Query(value = """
    SELECT ger.elenco_raccolte_id, COUNT(ger.giocatore_id)
    FROM giocatore_elenco_raccolte ger
    JOIN raccolta r ON r.id = ger.elenco_raccolte_id
    WHERE r.autore_id = :autoreId
    GROUP BY ger.elenco_raccolte_id
    ORDER BY COUNT(ger.giocatore_id) DESC
    LIMIT 4
    """, nativeQuery = true)
    public List<Object[]> getQuattroRaccoltePiuGiocate(@Param("autoreId") Long autoreId);
    
}
