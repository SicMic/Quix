package it.uniroma3.theboys.quix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.theboys.quix.model.Utente;
import it.uniroma3.theboys.quix.repository.UtenteRepository;

@Service
public class UtenteService {

    @Autowired UtenteRepository userRepository;

    public Iterable<Utente> getAllUsers(){
        return userRepository.findAll();
    }

    public Utente getUserById(Long id){
        return userRepository.findById(id).get();
    }
    

}
