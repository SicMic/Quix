package it.uniroma3.theboys.quix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.uniroma3.theboys.quix.service.UtenteService;

@Controller
public class UtenteController {
 
    @Autowired UtenteService utenteService;

	// @GetMapping("/login")
	// public String getLogin(Model model) {	//l'id preso dal path viene convertito in Long
	// 	model.addAttribute("utente", new Utente());
	// 	return "login.html";
	// }

	// @GetMapping("/loginDopo")
	// public String getLoginDopo(Model model, @RequestParam Utente year) {	//l'id preso dal path viene convertito in Long

	// 	return "login.html";
	// }


    @GetMapping("/utenti")
	public String getUtenti(Model model) {	//l'id preso dal path viene convertito in Long
		model.addAttribute("utenti", this.utenteService.getAllUtenti());	//l'id viene passato al metodo
		return "utenti.html";
	}
    
}
