package it.uniroma3.theboys.quix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
// import org.springframework.security.authentication.AnonymousAuthenticationToken;
// import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.theboys.quix.model.Autore;
import it.uniroma3.theboys.quix.model.Credenziali;
import it.uniroma3.theboys.quix.service.CredenzialiService;
import it.uniroma3.theboys.quix.service.UtenteService;
import jakarta.validation.Valid;

@Controller
public class AuthenticationController {

	@Autowired
	private UtenteService utenteService;
	
	@Autowired
	private CredenzialiService credenzialiService;
	
	@GetMapping(value = "/register") 
	public String showRegisterForm (Model model) {
		model.addAttribute("user", new Autore());
		model.addAttribute("credentials", new Credenziali());
		return "formRegisterUser";
	}

	// @PostMapping(value = { "/register" })
    // public String registerUser(@Valid @ModelAttribute("user") Autore autore,
    //              BindingResult userBindingResult, @Valid
    //              @ModelAttribute("credentials") Credenziali credenziali,
    //              BindingResult credentialsBindingResult,
    //              Model model) {

	// 	// se user e credential hanno entrambi contenuti validi, memorizza User e Credentials nel DB
    //     if(!userBindingResult.hasErrors() && !credentialsBindingResult.hasErrors()) {
    //         utenteService.saveUser(autore);
    //         credenziali.setUser(autore);
    //         credenzialiService.saveCredenziali(credenziali);
    //         model.addAttribute("user", autore);
    //         return "registrationSuccessful";
    //     }
    //     return "formRegisterUser";
    // }
	
	@GetMapping("/login") 
	public String showLoginForm (Model model) {
		return "login.html";
	}

	@GetMapping("/") 
	public String index(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication instanceof AnonymousAuthenticationToken) {
	        return "index.html";
		}
		else {		
			UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			Credenziali credenziali = credenzialiService.getCredenziali(userDetails.getUsername());
			if (credenziali.getRole().equals(Credenziali.AUTORE_ROLE)) {
				return "redirect:/autore/dashboard";
			}
		}
        return "index.html";
	}
		
    @GetMapping("/success")
    public String defaultAfterLogin(Model model) {
    	UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	Credenziali credenziali = credenzialiService.getCredenziali(userDetails.getUsername());
    	if (credenziali.getRole().equals(Credenziali.AUTORE_ROLE))
            return "redirect:/autore/dashboard";
    	if (credenziali.getRole().equals(Credenziali.GIOCATORE_ROLE))
            return "redirect:/giocatore/dashboard";
        return "index.html";
    }
}