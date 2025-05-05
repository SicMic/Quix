package it.uniroma3.theboys.quix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import it.uniroma3.theboys.quix.service.UtenteService;

@Controller
public class UtenteController {
 
    @Autowired UtenteService utenteService;

	@GetMapping("/login")
	public String getLogin(Model model) {	//l'id preso dal path viene convertito in Long
		//model.addAttribute("movie", this.movieService.getMovieById(id));	//l'id viene passato al metodo
		return "login.html";
	}

    @GetMapping("/utenti")
	public String getUtenti(Model model) {	//l'id preso dal path viene convertito in Long
		model.addAttribute("utenti", this.utenteService.getAllUtenti());	//l'id viene passato al metodo
		return "utenti.html";
	}
    
}
