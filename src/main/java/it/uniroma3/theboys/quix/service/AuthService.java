package it.uniroma3.theboys.quix.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.theboys.quix.model.Utente;
import it.uniroma3.theboys.quix.repository.*;

/* Servizio per l'autenticazione degli utenti e creazione della sessione */

@Service
public class AuthService {
    
    @Autowired
    UtenteRepository utenteRepository;

    public boolean autenticazione(String username, String password){
        Optional<Utente> utenteOpt = utenteRepository.findByUsername(username);
        return utenteOpt.map(utente -> utente.getPassword().equals(password)).orElse(false);
    }

    public Utente getUserByUsername(String username) {
        return utenteRepository.findByUsername(username).orElse(null);
    }
}
