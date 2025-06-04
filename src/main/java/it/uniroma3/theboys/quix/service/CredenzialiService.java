package it.uniroma3.theboys.quix.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.theboys.quix.model.Credenziali;
import it.uniroma3.theboys.quix.repository.CredenzialiRepository;

@Service
public class CredenzialiService {

    @Autowired
    protected PasswordEncoder passwordEncoder;

    @Autowired
    protected CredenzialiRepository credenzialiCredenzialiRepository;

    @Transactional
    public Credenziali getCredenziali(Long id) {
        Optional<Credenziali> result = this.credenzialiCredenzialiRepository.findById(id);
        return result.orElse(null);
    }

    @Transactional
    public Credenziali getCredenziali(String username) {
        Optional<Credenziali> result = this.credenzialiCredenzialiRepository.findByUsername(username);
        return result.orElse(null);
    }

    @Transactional
    public Credenziali saveCredenziali(Credenziali credenzialiCredenziali) {
        credenzialiCredenziali.setRole(Credenziali.AUTORE_ROLE);
        credenzialiCredenziali.setPassword(this.passwordEncoder.encode(credenzialiCredenziali.getPassword()));
        return this.credenzialiCredenzialiRepository.save(credenzialiCredenziali);
    }
}
