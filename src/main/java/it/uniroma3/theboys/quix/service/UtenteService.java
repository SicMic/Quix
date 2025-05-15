package it.uniroma3.theboys.quix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.theboys.quix.model.Utente;
import it.uniroma3.theboys.quix.repository.UtenteRepository;

@Service
public class UtenteService {

    @Autowired private UtenteRepository utenteRepository;

    public Iterable<Utente> getAllUtenti(){
        return utenteRepository.findAll();
    }

    public Utente getUtenteById(Long id){
        return utenteRepository.findById(id).get();
    }
    
    public Utente saveNewUtente(Utente utente){
        return this.utenteRepository.save(utente);
    }

}
