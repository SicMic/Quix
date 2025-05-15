package it.uniroma3.theboys.quix.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.theboys.quix.model.Autore;
import it.uniroma3.theboys.quix.model.Quiz;
import it.uniroma3.theboys.quix.model.Raccolta;
import it.uniroma3.theboys.quix.repository.AutoreRepository;

@Service
public class AutoreService {
    
    @Autowired private AutoreRepository autoreRepository;

    @Autowired private QuizService quizService;

    @Autowired private RaccoltaService raccoltaService;

    public Iterable<Autore> getAllAutori(){
        return this.autoreRepository.findAll();
    }

    public Autore getAutoreById(Long id){
        return this.autoreRepository.findById(id).get();
    }

    public Autore saveNewAutore(Autore autore){
        return this.autoreRepository.save(autore);
    }

    public Iterable<Quiz> getAllQuizAutore(Long autoreId){
        return this.quizService.getQuizByAutoreId(autoreId);
    }

    public Iterable<Quiz> getAllQuizAutoreOfCategoria(Long autoreId, String nomeCategoria){
        return this.quizService.getQuizByAutoreIdAndCategoriaNome(autoreId, nomeCategoria);
    }

    public Iterable<Raccolta> getAllRaccolteAutoreOfEtichetta(Long autoreId, String nomeEtichetta){
        return this.raccoltaService.getRaccoltaByEtichettaNomeAndAutore(autoreId, nomeEtichetta);
    }
}
