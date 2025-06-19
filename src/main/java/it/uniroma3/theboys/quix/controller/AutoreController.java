package it.uniroma3.theboys.quix.controller;

import java.util.HashMap;
import java.util.List;
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
import it.uniroma3.theboys.quix.model.Categoria;
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
		List<Raccolta> elencoRaccolte = autore.getElencoRaccolte();
		model.addAttribute("numeroRaccolte", elencoRaccolte.size());
		model.addAttribute("numeroQuiz", this.quizService.getNumeroQuizAutore(autore.getId())); // Numero quiz creati
		model.addAttribute("etichetta", this.raccoltaService.getEtichettaPiuUsata(autore.getId())); // Etichetta più
																									// usata
		model.addAttribute("categoria", this.quizService.getCategoriaPiuUsata(autore.getId())); // Categoria più usata
		model.addAttribute("raccolteGiocate", this.autoreService.getRaccoltePiuGiocate(autore.getId()));
		// da controllare comportamento -- se non ordinate corretamente va fatto sort
		// con Comparator su dataCreazione
		model.addAttribute("ultimiQuiz", this.autoreService.getAllQuizAutore(autore.getId()));
		model.addAttribute("raccolte", elencoRaccolte);

		return "dashboard.html";
	}

	// QUIZ- START
	@GetMapping("/autore/elencoQuiz")
	public String getElencoQuizAutore(Model model) {
		Autore autore = (Autore) model.getAttribute("utente");
		model.addAttribute("elenco", this.autoreService.getAllQuizAutore(autore.getId()));
		model.addAttribute("categorie", categoriaService.getAllCategorie());
		return "elencoQuiz.html";
	}

	@PostMapping("/autore/aggiuntaQuiz")
	public String aggiuntaNuovoQuizAutore(Model model,
			@RequestParam String quesito,
			@RequestParam String opzioneUno,
			@RequestParam String opzioneDue,
			@RequestParam String opzioneTre,
			@RequestParam String opzioneQuattro,
			@RequestParam Long idRaccolta,
			@RequestParam String categoria) {
		// Recupera la raccolta e la categoria utilizzando i loro ID
		Raccolta raccolta = raccoltaService.getRaccoltaById(idRaccolta);
		Categoria c = categoriaService.getCategoriaByNome(categoria);
		Quiz quiz = new Quiz(quesito, opzioneUno, opzioneDue, opzioneTre, opzioneQuattro, raccolta, c);
		this.quizService.saveNewQuiz(quiz);
		return "redirect:/autore/elencoQuiz"; // Modifica il percorso di reindirizzamento se necessario
	}

	@GetMapping("/autore/elencoQuiz/{nomeCategoria}")
	public String getElencoQuizAutore(Model model, @PathVariable("nomeCategoria") String nomeCategoria) {
		Autore autore = (Autore) model.getAttribute("utente");
		// model.addAttribute("nuovoQuiz", new Quiz());
		model.addAttribute("nomeCategoria", nomeCategoria);
		model.addAttribute("elenco", this.autoreService
				.getAllQuizAutoreOfCategoria(autore.getId(), nomeCategoria));
		model.addAttribute("categorie", categoriaService.getAllCategorie());
		return "elencoQuiz.html";
	}

	@PostMapping("/autore/aggiornamentoQuiz")
	public ResponseEntity<Map<String, String>> aggiornamentoQuizAutore(@RequestParam Long idQuiz,
			@RequestParam String quesito,
			@RequestParam String opzioneUno, @RequestParam String opzioneDue,
			@RequestParam String opzioneTre,
			@RequestParam String opzioneQuattro, @RequestParam String categoria) {
		Map<String, String> response = new HashMap<>();
		if (idQuiz == null || quesito == null || opzioneUno == null || opzioneDue == null || opzioneTre == null
				|| opzioneQuattro == null || categoria == null) {
			response.put("error", "Errore alcuni parametri sono nulli");
			return ResponseEntity.badRequest().body(response);
		}
		if (idQuiz < 1) {
			response.put("error", "ID Quiz non valido");
			return ResponseEntity.badRequest().body(response);
		}
		try {
			if (quizService.getQuizById(idQuiz) == null) {
				response.put("error", "Quiz non trovato nel database");
				return ResponseEntity.ok(response);
			}
			this.quizService.updateQuiz(idQuiz, quesito, opzioneUno, opzioneDue, opzioneTre, opzioneQuattro, categoria);
			response.put("message", "Quiz aggiornato con successo");
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			response.put("error", "Errore durante l'aggiornamento del quiz: " +
					e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}

	@PostMapping("/autore/eliminazioneQuiz")
	public ResponseEntity<Map<String, String>> eliminazioneQuizAutore(@RequestParam("idQuiz") Long idQuiz) {
		Map<String, String> response = new HashMap<>();
		if (idQuiz == null || idQuiz < 1) {
			response.put("error", "ID Quiz non valido");
			return ResponseEntity.badRequest().body(response);
		}
		try {
			if (quizService.getQuizById(idQuiz) == null) {
				response.put("error", "Quiz non trovato nel database");
				return ResponseEntity.ok(response);
			}
			this.quizService.deleteQuiz(idQuiz);
			response.put("message", "Quiz eliminato con successo");
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			response.put("error", "Errore durante l'eliminazione del quiz: " +
					e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}
	// QUIZ- END

	// RACCOLTE - START
	@GetMapping("/autore/raccolte")
	public String getRaccolteAutore(Model model) {
		Autore autore = (Autore) model.getAttribute("utente");
		// model.addAttribute("newRaccolta", new Raccolta());
		model.addAttribute("raccolte", autore.getElencoRaccolte());
		Map<String, String> mappaEtichette = new HashMap<>();
		for (Etichetta e : autore.getEtichetteAutore())
			mappaEtichette.put(e.getNome(), e.getNome().replace(" ", "+"));
		model.addAttribute("mappaEtichette", mappaEtichette);
		model.addAttribute("etichette", autore.getEtichetteAutore());
		return "raccolte.html";
	}

	@GetMapping("/autore/raccolta/{idRaccolta}")
	public String getRaccoltaAutore(Model model, @PathVariable("idRaccolta") Long idRaccolta) {
		model.addAttribute("idRaccolta", idRaccolta);
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
				this.autoreService.getAllRaccolteAutoreOfEtichetta(autore.getId(), nomeEtichetta.replace("+", " ")));
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
	public ResponseEntity<Map<String, String>> eliminazioneRaccoltaAutore(@RequestParam("idRaccolta") Long idRaccolta) {
		Map<String, String> response = new HashMap<>();
		if (idRaccolta == null || idRaccolta < 1) {
			response.put("error", "ID Raccolta non valido");
			return ResponseEntity.badRequest().body(response);
		}
		try {
			if (raccoltaService.getRaccoltaById(idRaccolta) == null) {
				response.put("error", "Raccolta non trovata nel database");
				return ResponseEntity.ok(response);
			}
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
	public ResponseEntity<Map<String, String>> postAggiornamentoRaccoltaAutore(@RequestParam Long idRaccolta,
			@RequestParam String nome,
			@RequestParam String descrizione,
			@RequestParam String urlImage,
			@RequestParam String etichetta) {
		Map<String, String> response = new HashMap<>();
		if (idRaccolta == null || nome == null || descrizione == null || urlImage == null || etichetta == null) {
			response.put("error", "Errore alcuni parametri sono nulli");
			return ResponseEntity.badRequest().body(response);
		}
		if (idRaccolta < 1) {
			response.put("error", "ID Raccolta non valido");
			return ResponseEntity.badRequest().body(response);
		}
		try {
			if (raccoltaService.getRaccoltaById(idRaccolta) == null) {
				response.put("error", "Raccolta non trovato nel database");
				return ResponseEntity.ok(response);
			}
			// this.raccoltaService.updateRaccolta(idRaccolta, nome, descrizione, urlImage,
			// etichetta);
			response.put("message", "Raccolta aggiornato con successo");
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			response.put("error", "Errore durante l'aggiornamento della raccolta: " +
					e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
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

	@GetMapping("/lol")
	public String lol(Model model) {
		return "lol.html";
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
