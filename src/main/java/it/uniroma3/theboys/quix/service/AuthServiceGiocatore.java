package it.uniroma3.theboys.quix.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.theboys.quix.model.Giocatore;
import it.uniroma3.theboys.quix.repository.GiocatoreRepository;

/* Servizio per l'autenticazione degli utenti e creazione della sessione */

@Service
public class AuthServiceGiocatore {
    
    @Autowired GiocatoreRepository utenteRepository;

    // public boolean autenticazione(String username, String password){
    //     Optional<Giocatore> utenteOpt = utenteRepository.findByUsername(username);
    //     return utenteOpt.map(utente -> utente.getPassword().equals(password)).orElse(false);
    // }

    // public Giocatore getUserByUsername(String username) {
    //     return this.utenteRepository.findByUsername(username).orElse(null);
    // }
}
