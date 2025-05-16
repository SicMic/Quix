package it.uniroma3.theboys.quix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.theboys.quix.model.Giocatore;
import it.uniroma3.theboys.quix.repository.GiocatoreRepository;

@Service
public class GiocatoreService {

    @Autowired private GiocatoreRepository utenteRepository;

    public Iterable<Giocatore> getAllUtenti(){
        return utenteRepository.findAll();
    }

    public Giocatore getUtenteById(Long id){
        return utenteRepository.findById(id).get();
    }
    
    public Giocatore saveNewUtente(Giocatore utente){
        return this.utenteRepository.save(utente);
    }

}
