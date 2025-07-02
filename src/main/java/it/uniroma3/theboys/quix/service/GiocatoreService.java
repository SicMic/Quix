package it.uniroma3.theboys.quix.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.theboys.quix.model.Giocatore;
import it.uniroma3.theboys.quix.repository.GiocatoreRepository;

@Service
public class GiocatoreService {

    @Autowired
    private GiocatoreRepository giocatoreRepository;

    @Autowired
    private RaccoltaService raccoltaService;

    public Iterable<Giocatore> getAllGiocatori() {
        return this.giocatoreRepository.findAll();
    }

    public Giocatore getGicatoreById(Long id) {
        return this.giocatoreRepository.findById(id).get();
    }

    public Giocatore saveNewGiocatore(Giocatore giocatore) {
        return this.giocatoreRepository.save(giocatore);
    }

    public String getEtichettaPiuGiocata(Long giocatoreId) {
        return this.raccoltaService.getEtichettaPiuGiocata(giocatoreId);

    }

    public Giocatore updateGiocatore(Giocatore giocatore) {
        return this.giocatoreRepository.save(giocatore);
    }

    // public List<Object[]> getClassifica(){
    // return this.giocatoreRepository.getUsernameEPunteggi();
    // }

    public List<ClassificaDTO> getClassifica() {
        List<Object[]> results = this.giocatoreRepository.getUsernameEPunteggi();
        return results.stream()
                .map(result -> new ClassificaDTO(
                        (String) result[0],
                        (Integer) result[1],
                        ((Timestamp) result[2]).toLocalDateTime() // Conversione da Timestamp a LocalDateTime
                ))
                .collect(Collectors.toList());
    }
}
