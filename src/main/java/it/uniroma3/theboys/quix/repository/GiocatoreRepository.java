package it.uniroma3.theboys.quix.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.uniroma3.theboys.quix.model.Giocatore;
import jakarta.transaction.Transactional;


public interface GiocatoreRepository extends CrudRepository<Giocatore, Long>{
    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM giocatore_elenco_raccolte WHERE elenco_raccolte_id = :raccoltaId", nativeQuery = true)
    int deleteAllByRaccoltaId(@Param("raccoltaId") Long raccoltaId);
}
