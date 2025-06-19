package it.uniroma3.theboys.quix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.uniroma3.theboys.quix.model.Giocatore;


public interface GiocatoreRepository extends CrudRepository<Giocatore, Long>{

    @Query(value = """
        SELECT c.username, g.punteggio
        FROM giocatore g
        JOIN credenziali c ON c.id = g.id
        ORDER BY g.punteggio DESC
    """, nativeQuery = true)
    public List<Object[]> getUsernameEPunteggi();

}
