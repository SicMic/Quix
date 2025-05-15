package it.uniroma3.theboys.quix.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.theboys.quix.model.Autore;
import it.uniroma3.theboys.quix.repository.AutoreRepository;

/* Servizio per l'autenticazione degli utenti e creazione della sessione */

@Service
public class AuthServiceAutore {
    
    @Autowired private AutoreRepository autoreRepository;

    public boolean autenticazione(String username, String password){
        Optional<Autore> autoreOpt = autoreRepository.findByUsername(username);
        return autoreOpt.map(autore -> autore.getPassword().equals(password)).orElse(false);
    }

    public Autore getAutoreByUsername(String username) {
        return this.autoreRepository.findByUsername(username).orElse(null);
    }
}
