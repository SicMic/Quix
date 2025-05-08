package it.uniroma3.theboys.quix.service;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.theboys.quix.model.Raccolta;
import it.uniroma3.theboys.quix.model.Quiz;
import it.uniroma3.theboys.quix.repository.RaccoltaRepository;

//classe per definire le operazioni CRUD tramite metodi java: descrive i servizi offerti
@Service
public class RaccoltaService {
	@Autowired
	private RaccoltaRepository raccoltaRepository;	//istanza costruita e inizializzata dal framework

    public Raccolta getRaccoltaById(Long id) {
        return raccoltaRepository.findById(id).get();
    }

	public Iterable<Raccolta> getAllRaccolte(){
		return raccoltaRepository.findAll();
	}

	// public ArrayList<Quiz> getAllQuizzes(Raccolta r){
	// 	return new ArrayList<Quiz>(r.getElencoQuiz());
	// }
	
	public Raccolta save(Raccolta r){
		return this.raccoltaRepository.save(r);
	}

}