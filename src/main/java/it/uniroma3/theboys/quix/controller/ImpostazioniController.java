package it.uniroma3.theboys.quix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class ImpostazioniController {
    
    @GetMapping("/impostazioni")
	public String getImpostazioni(Model model, HttpSession session) {
		
		if(session.getAttribute("user") == null)
			return "redirect:/login";
		
		model.addAttribute("utente", session.getAttribute("user"));
		return "impostazioni.html";
	}

}
