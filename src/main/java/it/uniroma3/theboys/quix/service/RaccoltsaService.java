package it.uniroma3.theboys.quix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.theboys.quix.model.Raccolta;
import it.uniroma3.theboys.quix.repository.RaccoltaRepository;

//classe per definire le operazioni CRUD tramite metodi java: descrive i servizi offerti
@Service
public class RaccoltsaService {
	@Autowired
	private RaccoltaRepository raccoltaRepository;	//istanza costruita e inizializzata dal framework

    public Raccolta getQuizById(Long id) {
        return raccoltaRepository.findById(id).get();
    }

	public Iterable<Raccolta> getAllQuizzes(){
		return raccoltaRepository.findAll();
	}
	
	public Raccolta save(Raccolta r){
		return this.raccoltaRepository.save(r);
	}

}