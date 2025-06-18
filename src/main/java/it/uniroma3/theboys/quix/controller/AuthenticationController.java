package it.uniroma3.theboys.quix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.theboys.quix.model.Autore;
import it.uniroma3.theboys.quix.model.Giocatore;
import it.uniroma3.theboys.quix.service.AutoreService;
import it.uniroma3.theboys.quix.model.Credenziali;
import it.uniroma3.theboys.quix.service.CredenzialiService;
import it.uniroma3.theboys.quix.service.GiocatoreService;
import jakarta.validation.Valid;

@Controller
public class AuthenticationController {

	@Autowired
	private AutoreService autoreService;

	@Autowired
	private GiocatoreService giocatoreService;

	@Autowired
	private CredenzialiService credenzialiService;

	AuthenticationController(AutoreService autoreService) {
		this.autoreService = autoreService;
	}

	@GetMapping("/autore/registrazione")
	public String registrazioneAutore(Model model) {
		model.addAttribute("ruolo", new String("autore"));
		model.addAttribute("autore", new Autore());
		model.addAttribute("credenziali", new Credenziali());
		return "registrazione.html";
	}

	@GetMapping("/giocatore/registrazione")
	public String registrazioneGiocatore(Model model) {
		model.addAttribute("ruolo", new String("giocatore"));
		model.addAttribute("giocatore", new Giocatore());
		model.addAttribute("credenziali", new Credenziali());
		return "registrazione.html";
	}

	@PostMapping("/autore/registrazione")
	public String registrazioneAutore(@Valid @ModelAttribute("autore") Autore autore,
			BindingResult userBindingResult, @Valid @ModelAttribute("credenziali") Credenziali credenziali,
			BindingResult credentialsBindingResult,
			Model model) {
		if (!userBindingResult.hasErrors() && !credentialsBindingResult.hasErrors()) {
			if(credenzialiService.getCredenziali(credenziali.getUsername()) != null)
				return "redirect:/autore/registrazione/errore ";
			credenziali.setRole("AUTORE");
			// Salva prima le credenziali
			credenzialiService.saveCredenziali(credenziali);
			// Ora puoi impostare l'utente nelle credenziali
			credenziali.setUtente(autore);
			autore.setCredenziali(credenziali);
			// Salva l'autore
			autoreService.saveNewAutore(autore);
			model.addAttribute("user", autore); // DA RIVEDERE
			return "redirect:/login";
		}
		return "errore";
	}

	@PostMapping("/giocatore/registrazione")
	public String registrazioneGiocatore(@Valid @ModelAttribute("giocatore") Giocatore giocatore,
			BindingResult userBindingResult, @Valid @ModelAttribute("credenziali") Credenziali credenziali,
			BindingResult credentialsBindingResult,
			Model model) {
		if (!userBindingResult.hasErrors() && !credentialsBindingResult.hasErrors()) {
			if(credenzialiService.getCredenziali(credenziali.getUsername()) != null)
				return "redirect:/autore/registrazione/errore ";
			credenziali.setRole("GIOCATORE");
			// Salva prima le credenziali
			credenzialiService.saveCredenziali(credenziali);
			// Ora puoi impostare l'utente nelle credenziali
			credenziali.setUtente(giocatore);
			giocatore.setCredenziali(credenziali);
			// Salva il giocatore
			giocatoreService.saveNewGiocatore(giocatore);
			model.addAttribute("user", giocatore); // DA RIVEDERE
			return "redirect:/login";
		}
		return "errore";
	}

	@GetMapping("/autore/registrazione/errore")
	public String registrazioneAutoreErrore(Model model) {
		model.addAttribute("errore", new String("errore"));
		model.addAttribute("ruolo", new String("autore"));
		model.addAttribute("autore", new Autore());
		model.addAttribute("credenziali", new Credenziali());
		return "registrazione.html";
	}

	@GetMapping("/giocatore/registrazione/errore")
	public String registrazioneGiocatorereErrore(Model model) {
		model.addAttribute("errore", new String("errore"));
		model.addAttribute("ruolo", new String("autore"));
		model.addAttribute("giocatore", new Giocatore());
		model.addAttribute("credenziali", new Credenziali());
		return "registrazione.html";
	}

	@GetMapping("/login")
	public String login(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null && authentication.isAuthenticated()
				&& !(authentication instanceof AnonymousAuthenticationToken)) {
			// Reindirizza l'utente a un'altra pagina se è già autenticato
			return "redirect:/" + model.getAttribute("ruolo") + "/dashboard";
		}
		return "login.html"; // Mostra la pagina di login se non autenticato
	}

	@GetMapping("/")
	public String index(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication instanceof AnonymousAuthenticationToken) {
			return "index.html";
		} else {
			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			Credenziali credenziali = credenzialiService.getCredenziali(userDetails.getUsername());
			if (credenziali.getRole().equals(Credenziali.AUTORE_ROLE)) {
				return "redirect:/autore/dashboard";
			}
		}
		return "index.html";
	}

	@GetMapping("/success")
	public String defaultAfterLogin(Model model) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Credenziali credenziali = credenzialiService.getCredenziali(userDetails.getUsername());
		if (credenziali.getRole().equals(Credenziali.AUTORE_ROLE))
			return "redirect:/autore/dashboard";
		if (credenziali.getRole().equals(Credenziali.GIOCATORE_ROLE))
			return "redirect:/giocatore/dashboard";
		return "index.html";
	}
}