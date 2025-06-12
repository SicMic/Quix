package it.uniroma3.theboys.quix.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import it.uniroma3.theboys.quix.model.Giocatore;
import it.uniroma3.theboys.quix.model.Autore;
import it.uniroma3.theboys.quix.model.Etichetta;
import it.uniroma3.theboys.quix.model.Quiz;
import it.uniroma3.theboys.quix.model.Raccolta;
import it.uniroma3.theboys.quix.service.AutoreService;
import it.uniroma3.theboys.quix.service.CategoriaService;
import it.uniroma3.theboys.quix.service.EtichettaService;
import it.uniroma3.theboys.quix.service.GiocatoreService;
import it.uniroma3.theboys.quix.service.QuizService;
import it.uniroma3.theboys.quix.service.RaccoltaService;

@Controller
public class GiocatoreController {

	@Autowired private RaccoltaService raccoltaService;

	@Autowired private QuizService quizService;

	@Autowired private EtichettaService etichettaService;

	@Autowired private CategoriaService categoriaService;

	@Autowired private GiocatoreService giocatoreService;

	@GetMapping("/giocatore/dashboard")
	public String getDashboardGiocatore(Model model) {
		Giocatore giocatore = (Giocatore) model.getAttribute("utente");
		List<Raccolta> elencoRaccolte = giocatore.getElencoRaccolte();
		model.addAttribute("numeroRaccolte", elencoRaccolte.size());  //Raccolte giocate dal giocatore
		//vedere se funziona, se no va fatta la query in service e repository
		int numeroQuiz = 0;
		for(Raccolta raccolta : elencoRaccolte)
			numeroQuiz += raccolta.getElencoQuiz().size();
		model.addAttribute("numeroQuiz", numeroQuiz); //Numero quiz giocati
		//per ultime 4 raccolte giocate prendere le prime 4 da elenco raccolte 		---- aggiungere data in cui è stata giocata in join table raccolte+giocatori
		model.addAttribute("etichetta", this.giocatoreService.getEtichettaPiuGiocata(giocatore.getId())); //Etichetta più giocata
		// model.addAttribute("categoria", this.quizService.getCategoriaPiuUsata(autore.getId()));
		model.addAttribute("numeroRaccolte", elencoRaccolte);  //Raccolte

		return "dashboard.html";
	}

	// RACCOLTE - START
	@GetMapping("/giocatore/raccolte")
	public String getRaccolteGiocatore(Model model) {
		model.addAttribute("raccolte", this.raccoltaService.getAllRaccolte());
		Map<String, String> mappaEtichette = new HashMap<>();
		for (Etichetta e : etichettaService.getAllEtichette())
			mappaEtichette.put(e.getNome(), e.getNome().replace(" ", "+"));
		model.addAttribute("mappaEtichette", mappaEtichette);
		model.addAttribute("etichette", etichettaService.getAllEtichette());
		return "raccolte.html";
	}

	@GetMapping("/giocatore/raccolte/{nomeEtichetta}")
	public String getRacccolteEtichettaAutore(Model model, @PathVariable("nomeEtichetta") String nomeEtichetta) {
		model.addAttribute("nomeEtichetta", nomeEtichetta);
		model.addAttribute("raccolte", this.raccoltaService.getRaccoltaByEtichettaNome(nomeEtichetta.replace("+", " ")));
		return "raccolte.html";
	}
	// RACCOLTE - END


	// ALTRO - START
	@GetMapping("/giocatore/profilo")
	public String getProfiloGiocatore(Model model) {
		Giocatore autore = (Giocatore) model.getAttribute("utente");
		model.addAttribute("username", autore.getCredenziali().getUsername());
		return "profilo.html";
	}

	@GetMapping("/giocatore/impostazioni")
	public String getImpostazioniGiocatore(Model model) {
		return "impostazioni.html";
	}

	// @GetMapping("/logout")
	// public String logout() {
	// // if (session.getAttribute("user") == null)
	// // return "redirect:/login";

	// // session.invalidate();
	// return "redirect:/";

	// }
	// ALTRO - END

}
