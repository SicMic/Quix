package it.uniroma3.theboys.quix.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import it.uniroma3.theboys.quix.model.Autore;
import it.uniroma3.theboys.quix.model.Etichetta;
import it.uniroma3.theboys.quix.model.Quiz;
import it.uniroma3.theboys.quix.model.Raccolta;
import it.uniroma3.theboys.quix.service.AutoreService;
import it.uniroma3.theboys.quix.service.CategoriaService;
import it.uniroma3.theboys.quix.service.EtichettaService;
import it.uniroma3.theboys.quix.service.QuizService;
import it.uniroma3.theboys.quix.service.RaccoltaService;

@Controller
public class AutoreController {

	@Autowired
	private AutoreService autoreService;

	@Autowired
	private RaccoltaService raccoltaService;

	@Autowired
	private QuizService quizService;

	@Autowired
	private EtichettaService etichettaService;

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping("/autore/dashboard")
	public String getDashboardAutore(Model model) {
		Autore autore = (Autore) model.getAttribute("utente");
		model.addAttribute("raccolte", autore.getElencoRaccolte());
		model.addAttribute("numeroRaccolte", 2);
		model.addAttribute("numeroQuiz", this.quizService.getNumeroQuizAutore(autore.getId()));
		model.addAttribute("etichetta", this.raccoltaService.getEtichettaPiuUsata(autore.getId()));
		model.addAttribute("categoria", this.quizService.getCategoriaPiuUsata(autore.getId()));

		return "dashboard.html";
	}

	// QUIZ- START
	@PostMapping("/autore/aggiuntaQuiz")
	public String aggiuntaNuovoQuizAutore(@RequestParam("quesito") String quesito,
			@RequestParam("opzioneUno") String opzioneUno, @RequestParam("opzioneDue") String opzioneDue,
			@RequestParam("opzioneTre") String opzioneTre,
			@RequestParam("opzioneQuattro") String opzioneQuattro,
			@RequestParam("idRaccolta") Long idRaccolta, @RequestParam("categoria") String categoria) {
		Quiz quiz = new Quiz(quesito, opzioneUno, opzioneDue, opzioneTre,
				opzioneQuattro,
				this.raccoltaService.getRaccoltaById(idRaccolta),
				categoriaService.getQuizByNome(categoria),
				java.time.LocalDate.now());
		this.quizService.saveNewQuiz(quiz);
		return "redirect:/raccolta/" + idRaccolta;
	}

	@PostMapping("/autore/eliminazioneQuiz")
	public ResponseEntity<String> eliminazioneQuizAutore(@RequestParam Long idQuiz) {
		try {
			this.quizService.deleteQuiz(idQuiz);
			return ResponseEntity.ok("Quiz eliminato con successo");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Errore durante l'eliminazione del quiz: " + e.getMessage());
		}
	}
	// QUIZ- END

	// ELENCO QUIZ- START
	@GetMapping("/autore/elencoQuiz")
	public String getElencoQuizAutore(Model model) {
		Autore autore = (Autore) model.getAttribute("utente");
		model.addAttribute("elenco", this.autoreService.getAllQuizAutore(autore.getId()));
		model.addAttribute("categorie", categoriaService.getAllCategorie());
		// model.addAttribute("paginaCorrente", "elencoQuiz");

		return "elencoQuiz.html";
	}

	@GetMapping("/autore/elencoQuiz/{nomeCategoria}")
	public String getElencoQuizAutore(Model model, @PathVariable("nomeCategoria") String nomeCategoria) {
		Autore autore = (Autore) model.getAttribute("utente");
		model.addAttribute("nomeCategoria", nomeCategoria);
		model.addAttribute("elenco", this.autoreService
				.getAllQuizAutoreOfCategoria(autore.getId(), nomeCategoria));
		model.addAttribute("categorie", categoriaService.getAllCategorie());
		// model.addAttribute("paginaCorrente", "elencoQuiz/nomeCategoria");
		return "elencoQuiz.html";
	}

	@PostMapping("/autore/aggiornamentoQuiz")
	public void postAggiornamentoQuizAutore(@RequestParam Long idQuiz, @RequestParam String quesito,
			@RequestParam String opzioneUno, @RequestParam String opzioneDue,
			@RequestParam String opzioneTre,
			@RequestParam String opzioneQuattro, @RequestParam String categoria) {
		this.quizService.updateQuiz(idQuiz, quesito, opzioneUno, opzioneDue,
				opzioneTre, opzioneQuattro, categoria);
	}
	// ELENCO QUIZ- END

	// RACCOLTE - START
	@GetMapping("/autore/raccolte")
	public String getRaccolteAutore(Model model) {
		Autore autore = (Autore) model.getAttribute("utente");
		model.addAttribute("raccolte", autore.getElencoRaccolte());
		Map<String, String> mappaEtichette = new HashMap<>();
		for (Etichetta e : etichettaService.getAllEtichette())
			mappaEtichette.put(e.getNome(), e.getNome().replace(" ", "+"));
		model.addAttribute("mappaEtichette", mappaEtichette);
		model.addAttribute("etichette", etichettaService.getAllEtichette());
		return "raccolte.html";
	}

	@GetMapping("/autore/raccolta/{idRaccolta}")
	public String getRaccoltaAutore(Model model, @PathVariable("idRaccolta") Long idRaccolta) {
		model.addAttribute("nomeRaccolta", raccoltaService.getRaccoltaById(idRaccolta).getNome());
		model.addAttribute("elenco", raccoltaService.getRaccoltaById(idRaccolta).getElencoQuiz());
		model.addAttribute("categorie", categoriaService.getAllCategorie());
		model.addAttribute("paginaCorrente", "raccolta");

		return "raccolta.html";
	}

	@GetMapping("/autore/raccolte/{nomeEtichetta}")
	public String getRacccolteEtichettaAutore(Model model, @PathVariable("nomeEtichetta") String nomeEtichetta) {
		Autore autore = (Autore) model.getAttribute("utente");
		model.addAttribute("nomeEtichetta", nomeEtichetta);
		model.addAttribute("raccolte",
				this.autoreService.getAllRaccolteAutoreOfEtichetta(autore.getId(), nomeEtichetta.replace("+", "")));
		return "raccolte.html";
	}

	@PostMapping("/autore/aggiuntaRaccolta")
	public String aggiuntaNuovaRaccoltaAutore(Model model, @RequestParam String nome, @RequestParam String urlImage,
			@RequestParam String etichetta, @RequestParam String descrizione) {
		Autore autore = (Autore) model.getAttribute("utente");
		Raccolta raccolta = new Raccolta(nome, urlImage, etichettaService.getEtichettaByNome(etichetta), descrizione,
				autore);
		this.raccoltaService.saveNewRaccolta(raccolta);
		return "redirect:/autore/raccolte";
	}

	@PostMapping("/autore/eliminazioneRaccolta")
	public ResponseEntity<Map<String, String>> eliminazioneRaccoltaAutore(@RequestParam Long idRaccolta) {
		Map<String, String> response = new HashMap<>();
		try {
			this.raccoltaService.deleteRaccolta(idRaccolta);
			response.put("message", "Raccolta eliminata con successo");
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			response.put("error", "Errore durante l'eliminazione della raccolta: " +
					e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}

	@PostMapping("/autore/aggiornamentoRaccolta")
	public void postAggiornamentoRaccoltaAutore(@RequestParam Long idRaccolta,
			@RequestParam String nome,
			@RequestParam String descrizione, @RequestParam String urlImage,
			@RequestParam String etichetta) {
		this.raccoltaService.updateRaccolta(idRaccolta, nome, descrizione, urlImage, etichetta);
	}
	// RACCOLTE - END

	// ALTRO - START
	@GetMapping("/autore/profilo")
	public String getProfiloAutore(Model model) {
		Autore autore = (Autore) model.getAttribute("utente");
		model.addAttribute("username", autore.getCredenziali().getUsername());
		return "profilo.html";
	}

	@GetMapping("/autore/impostazioni")
	public String getImpostazioniAutore(Model model) {
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
