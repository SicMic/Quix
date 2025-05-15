package it.uniroma3.theboys.quix.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired QuizService quizService;
	@Autowired RaccoltaService raccoltaService;

	@GetMapping("/quiz/{idRaccolta}/{indice}") 
		public String getQuizProva(@PathVariable("idRaccolta") Long idRaccolta, @PathVariable("indice") Integer indice, Model model) { 
		Raccolta raccolta = raccoltaService.getRaccoltaById(idRaccolta);
		ArrayList<Quiz> quizzes = new ArrayList(raccolta.getElencoQuiz());
		model.addAttribute("quiz", quizzes.get(--indice));
		return "quiz.html";
	}

	@PostMapping("/quiz")
    public String submitQuiz(@RequestParam String risposta, @RequestParam Integer idRaccolta, @RequestParam Integer indice) {
		//Passo uno mi salvo il punteggio in una variabile di sessione
        indice = indice + 1;
        return "redirect:" + idRaccolta.toString() + "/" + indice.toString();
    }


}