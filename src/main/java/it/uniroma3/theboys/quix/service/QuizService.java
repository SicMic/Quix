package it.uniroma3.theboys.quix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.theboys.quix.model.Quiz;
import it.uniroma3.theboys.quix.repository.QuizRepository;

//classe per definire le operazioni CRUD tramite metodi java: descrive i servizi offerti
@Service
public class QuizService {
	@Autowired private QuizRepository quizRepository;	//istanza costruita e inizializzata dal framework

	@Autowired private CategoriaService categoriaService;

    public Quiz getQuizById(Long id) {
        return this.quizRepository.findById(id).get();
    }

	public Iterable<Quiz> getAllQuizzes(){
		return this.quizRepository.findAll();
	}
	
	public Quiz saveNewQuiz(Quiz q){
		return this.quizRepository.save(q);
	}

	public void deleteQuiz(Long id){
		this.quizRepository.deleteById(id);
	}

	public Iterable<Quiz> getQuizByCategoriaId(Long categoriaId){
		return this.quizRepository.findByCategoriaId(categoriaId);
	}

	public Iterable<Quiz> getQuizByAutoreId(Long autoreId){
		return this.quizRepository.findByAutoreIdNative(autoreId);
	}

	public Iterable<Quiz> getQuizByAutoreIdAndCategoriaNome(Long autoreId, String nomeCategoria){
		return this.quizRepository.findByAutoreIdAndCategoriaNomeNative(autoreId, nomeCategoria);
	}

	public void updateQuiz(Long id, String quesito, String opzioneUno, String opzioneDue, String opzioneTre, String opzioneQuattro, String nomeCategoria){
		Quiz q = this.getQuizById(id);
		q.setQuesito(quesito);
		q.setOpzioneUno(opzioneUno);
		q.setOpzioneDue(opzioneDue);
		q.setOpzioneTre(opzioneTre);
		q.setOpzioneQuattro(opzioneQuattro);
		q.setCategoria(categoriaService.getQuizByNome(nomeCategoria));
		this.quizRepository.save(q);
	}

}