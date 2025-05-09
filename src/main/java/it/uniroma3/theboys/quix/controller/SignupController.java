package it.uniroma3.theboys.quix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.theboys.quix.model.Autore;
import it.uniroma3.theboys.quix.service.AutoreService;
import it.uniroma3.theboys.quix.service.UtenteService;

@Controller
public class SignupController {

    @Autowired
    AutoreService autoreService;
    @Autowired
    UtenteService utenteService;
    
    @GetMapping("/signUp")
		public String registrazione(Model model) {
		model.addAttribute("autore", new Autore());
        //model.addAllAttributes("ruolo", new String());
		return "registrazione.html";
  	}


	@PostMapping("/signUp")
  	public String newMovie(@ModelAttribute("autore") Autore autore, Model model) {

        this.autoreService.saveNewAutore(autore);

        // if (ruolo == "autore")      //da mettere equals
		//     this.autoreService.saveNewAutore(autore);
        // else
        //     this.utenteService.saveNewUtente((Utente) autore);
		return "redirect:prova"; // modificare in base a struttura url dashboard
	}

}
