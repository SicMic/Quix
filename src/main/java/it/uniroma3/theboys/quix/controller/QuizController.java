package it.uniroma3.theboys.quix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

import it.uniroma3.theboys.quix.model.Quiz;
import it.uniroma3.theboys.quix.model.Raccolta;
import it.uniroma3.theboys.quix.service.QuizService;
import it.uniroma3.theboys.quix.service.RaccoltaService;

//classe che gestisce le richieste http tramite metodi Java
@Controller
public class QuizController {

	@Autowired
	QuizService quizService;
	@Autowired
	RaccoltaService raccoltaService;

	@GetMapping("/quiz/{idRaccolta}/{indiceQuiz}/{punteggio}")
	public String getQuiz(@PathVariable("idRaccolta") Long idRaccolta,
			@PathVariable("indiceQuiz") Integer indiceQuiz, @PathVariable("punteggio") Integer punteggio, Model model) {
		Raccolta raccolta = raccoltaService.getRaccoltaById(idRaccolta);
		ArrayList<Quiz> quizzes = new ArrayList(raccolta.getElencoQuiz());
		if (indiceQuiz <= quizzes.size()) {
			Quiz quiz = quizzes.get(--indiceQuiz);
			model.addAttribute("risposta", quiz.getOpzioneUno());
			quiz.shuffle();
			model.addAttribute("quiz", quiz);
			model.addAttribute("punteggio", punteggio);
			return "quiz.html";
		}

		return "dashboardGiocatore.html";
	}
	
	@PostMapping("/quiz")
	public ResponseEntity<String> quizzetto(@RequestParam Integer idRaccolta,
			@RequestParam Integer indiceQuiz, @RequestParam Integer punteggio) {
		try {
			indiceQuiz = indiceQuiz + 1;
			return ResponseEntity.ok("/quiz/" + idRaccolta + "/" + indiceQuiz + "/" + punteggio);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Errore durante l'elaborazione del quiz: " + e.getMessage());
		}
	}
}
