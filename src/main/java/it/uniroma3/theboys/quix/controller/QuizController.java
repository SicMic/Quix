package it.uniroma3.theboys.quix.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.theboys.quix.model.Giocatore;
import it.uniroma3.theboys.quix.model.Quiz;
import it.uniroma3.theboys.quix.model.Raccolta;
import it.uniroma3.theboys.quix.service.GiocatoreService;
import it.uniroma3.theboys.quix.service.QuizService;
import it.uniroma3.theboys.quix.service.RaccoltaService;
import jakarta.servlet.http.HttpSession;

//classe che gestisce le richieste http tramite metodi Java
@Controller
public class QuizController {

	@Autowired QuizService quizService;

	@Autowired RaccoltaService raccoltaService;

	@Autowired GiocatoreService giocatoreService;
	
	@GetMapping("/quiz/{idRaccolta}")
	public String getQuiz(@PathVariable("idRaccolta") Long idRaccolta, Model model, HttpSession session) {
		if (session.getAttribute("indiceQuiz") == null){
			session.setAttribute("indiceQuiz", 0);
			session.setAttribute("punteggio", new Integer(0));
			Giocatore giocatore = (Giocatore) model.getAttribute("utente");
			giocatore.getElencoRaccolte().add(raccoltaService.getRaccoltaById(idRaccolta));
			giocatoreService.updateGiocatore(giocatore);
		}
		Raccolta raccolta = raccoltaService.getRaccoltaById(idRaccolta);
		ArrayList<Quiz> quizzes = new ArrayList<>(raccolta.getElencoQuiz());
		if ((int) session.getAttribute("indiceQuiz") < quizzes.size()) {
			Quiz quiz = quizzes.get((int) session.getAttribute("indiceQuiz"));
			model.addAttribute("risposta", quiz.getOpzioneUno());
			quiz.shuffle();
			model.addAttribute("quiz", quiz);
			return "quiz.html";
		}

		model.addAttribute("punteggio", session.getAttribute("punteggio"));
		Giocatore giocatore = (Giocatore) model.getAttribute("utente");
		giocatore.sommaPunteggio((Integer) session.getAttribute("punteggio"));
		this.giocatoreService.updateGiocatore(giocatore);

		session.removeAttribute("indiceQuiz");
		session.removeAttribute("punteggio");
		return "quizfinito.html";
	}
	
	@PostMapping("/quiz")
	public ResponseEntity<String> postQuiz(@RequestParam Long idRaccolta, HttpSession session, @RequestParam int punteggio) {
		try {
			int indiceQuiz = (int) session.getAttribute("indiceQuiz");
			session.setAttribute("indiceQuiz", indiceQuiz += 1);
			Integer punteggioTotale = (Integer) session.getAttribute("punteggio");
			session.setAttribute("punteggio", punteggioTotale+punteggio);
			return ResponseEntity.ok("tutto apposto fra");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Errore durante l'elaborazione del quiz: " + e.getMessage());
		}
	}
}
