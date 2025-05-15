package it.uniroma3.theboys.quix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.theboys.quix.model.Etichetta;
import it.uniroma3.theboys.quix.repository.EtichettaRepository;

@Service
public class EtichettaService {
    
    @Autowired private EtichettaRepository etichettaRepository;

    public Etichetta getEtichettaById(Long id){
        return this.etichettaRepository.findById(id).get();
    }

    public Iterable<Etichetta> getAllEtichette(){
        return this.etichettaRepository.findAll();
    }

    public Etichetta getEtichettaByNome(String nomeEtichetta){
        return this.etichettaRepository.findByNome(nomeEtichetta).get();
    }

    public Etichetta saveNewEtichetta(Etichetta e){
        return this.etichettaRepository.save(e);
    }
}
