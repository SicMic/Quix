package it.uniroma3.theboys.quix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.theboys.quix.model.Giocatore;
import it.uniroma3.theboys.quix.service.AuthServiceGiocatore;
import it.uniroma3.theboys.quix.service.GiocatoreService;
import jakarta.servlet.http.HttpSession;

@Controller
public class SignupController {

    // @Autowired
    // AutoreService autoreService;
    @Autowired
    private GiocatoreService utenteService;
    @Autowired
    private AuthServiceGiocatore authService;
    
    // @GetMapping("/registrazione")
	// 	public String registrazione(Model model) {
	// 	//model.addAttribute("autore", new Autore());
    //     model.addAttribute("utente", new Utente());
    //     //model.addAttribute("ruolo", new String());
	// 	return "registrazione.html";
  	// }


	// // @PostMapping("/signUp")
  	// // public String newRegistrazione(@ModelAttribute("autore") Autore autore, @ModelAttribute("utente") Utente utente, @ModelAttribute("ruolo") String ruolo) {
    // //     if (ruolo.equals("autore"))      //da mettere equals
	// // 	    this.autoreService.saveNewAutore(autore);
    // //     else
    // //         this.utenteService.saveNewUtente(utente);
	// // 	return "redirect:dashboard"; // modificare in base a struttura url dashboard
	// // }

    // @PostMapping("/signUp")
  	// public String newRegistrazione(@ModelAttribute("utente") Utente utente, HttpSession session, Model model) {
    //     this.utenteService.saveNewUtente(utente);

	// 	session.setAttribute("user", authService.getUserByUsername(utente.getUsername()));
    //     session.setMaxInactiveInterval(60*5);                                           //timeout sessione dopo 5 minuti
    //     model.addAttribute("utente", session.getAttribute("user"));
    //     return "redirect:dashboardAutore"; // modificare in base a struttura url dashboard
	// }
}
