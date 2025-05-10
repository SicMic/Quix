package it.uniroma3.theboys.quix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import it.uniroma3.theboys.quix.model.Autore;
import it.uniroma3.theboys.quix.service.AutoreService;
import it.uniroma3.theboys.quix.service.RaccoltaService;
import jakarta.servlet.http.HttpSession;

@Controller
public class DashboardController {

    @Autowired
    private RaccoltaService raccoltaService;
	@Autowired
	private AutoreService autoreService;

    @GetMapping("/elencoQuiz/{idRaccolta}")
	public String getImpostazioni(Model model, HttpSession session, @PathVariable Long idRaccolta) {
		
		if(session.getAttribute("user") == null)
			return "redirect:/loginUtente";
		
		model.addAttribute("utente", session.getAttribute("user"));
        model.addAttribute("elenco", raccoltaService.getRaccoltaById(idRaccolta).getElencoQuiz());
		return "elencoQuiz.html";
	}

	@GetMapping("/dashboardAutore")
	public String getDashboard(Model model, HttpSession session) {
		
		if(session.getAttribute("user") == null)
			return "redirect:/loginAutore";
		
		model.addAttribute("utente", session.getAttribute("user"));
		model.addAttribute("raccolte", ((Autore) session.getAttribute("user")).getElencoRaccolte());
		return "dashboardAutore.html";
	}

}
