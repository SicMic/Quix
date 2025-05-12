package it.uniroma3.theboys.quix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.theboys.quix.model.Quiz;
import it.uniroma3.theboys.quix.repository.QuizRepository;

//classe per definire le operazioni CRUD tramite metodi java: descrive i servizi offerti
@Service
public class QuizService {
	@Autowired
	private QuizRepository quizRepository;	//istanza costruita e inizializzata dal framework

    public Quiz getQuizById(Long id) {
        return quizRepository.findById(id).get();
    }

	public Iterable<Quiz> getAllQuizzes(){
		return quizRepository.findAll();
	}
	
	public Quiz save(Quiz q){
		return this.quizRepository.save(q);
	}

	public void deleteQuiz(Long id){
		this.quizRepository.deleteById(id);
	}

}