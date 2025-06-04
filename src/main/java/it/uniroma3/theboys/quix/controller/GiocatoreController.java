package it.uniroma3.theboys.quix.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.uniroma3.theboys.quix.model.Autore;
import it.uniroma3.theboys.quix.model.Etichetta;
import it.uniroma3.theboys.quix.service.EtichettaService;
import it.uniroma3.theboys.quix.service.GiocatoreService;
import it.uniroma3.theboys.quix.service.RaccoltaService;
import jakarta.servlet.http.HttpSession;

@Controller
public class GiocatoreController {

	@Autowired
	private GiocatoreService utenteService;

	@Autowired
	private EtichettaService etichettaService;

	@Autowired
	private RaccoltaService raccoltaService;

	// // @GetMapping("/login")
	// // public String getLogin(Model model) { //l'id preso dal path viene convertito
	// // in Long
	// // model.addAttribute("utente", new Utente());
	// // return "login.html";
	// // }

	// // @GetMapping("/loginDopo")
	// // public String getLoginDopo(Model model, @RequestParam Utente year) { //l'id
	// // preso dal path viene convertito in Long

	// // return "login.html";
	// // }

	// // @GetMapping("/utenti")
	// // public String getUtenti(Model model) { //l'id preso dal path viene convertito
	// // in Long
	// // model.addAttribute("utenti", this.utenteService.getAllUtenti()); //l'id viene
	// // passato al metodo
	// // return "utenti.html";
	// // }

	// @GetMapping("/dashboardGiocatore")
	// public String getDashboard(Model model, HttpSession session) {

	// 	// if(session.getAttribute("user") == null)
	// 	// return "redirect:/login";

	// 	// model.addAttribute("utente", session.getAttribute("user"));
	// 	return "dashboardGiocatore.html";
	// }

	// @GetMapping("giocatore/raccolte")
	// public String getRaccolte(Model model, HttpSession session) {

	// 	if (session.getAttribute("user") == null)
	// 		return "redirect:/loginAutore";

	// 	model.addAttribute("utente", session.getAttribute("user"));
	// 	model.addAttribute("raccolte", raccoltaService.getAllRaccolte());
	// 	Map<String, String> mappaEtichette = new HashMap<>();
	// 	for (Etichetta e : etichettaService.getAllEtichette())
	// 		mappaEtichette.put(e.getNome(), e.getNome().replace(" ", "+"));
	// 	model.addAttribute("mappaEtichette", mappaEtichette);
	// 	model.addAttribute("etichette", etichettaService.getAllEtichette());

	// 	return "raccolteG.html";
	// }

}
