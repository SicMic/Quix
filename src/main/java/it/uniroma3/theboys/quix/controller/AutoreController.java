package it.uniroma3.theboys.quix.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.theboys.quix.model.Credenziali;
import it.uniroma3.theboys.quix.model.Autore;
import it.uniroma3.theboys.quix.model.Etichetta;
import it.uniroma3.theboys.quix.model.Quiz;
import it.uniroma3.theboys.quix.model.Raccolta;
import it.uniroma3.theboys.quix.model.Utente;
import it.uniroma3.theboys.quix.service.AuthServiceAutore;
import it.uniroma3.theboys.quix.service.AutoreService;
import it.uniroma3.theboys.quix.service.CategoriaService;
import it.uniroma3.theboys.quix.service.EtichettaService;
import it.uniroma3.theboys.quix.service.QuizService;
import it.uniroma3.theboys.quix.service.RaccoltaService;
import jakarta.servlet.http.HttpSession;

@Controller
public class AutoreController {

	@Autowired
	private AutoreService autoreService;

	@Autowired
	private RaccoltaService raccoltaService;

	@Autowired
	private AuthServiceAutore authServiceAutore;

	@Autowired
	private QuizService quizService;

	@Autowired
	private EtichettaService etichettaService;

	@Autowired
	private CategoriaService categoriaService;


	@GetMapping("/autore/dashboard")
	public String getDashboard(Model model) {
		Autore autore = (Autore) model.getAttribute("utente");
		// model.addAttribute("utente", crede);
		model.addAttribute("raccolte", autore.getElencoRaccolte());
		//model.addAttribute("numeroRaccolte", session.getAttribute("user")).getId());
		model.addAttribute("numeroQuiz", this.quizService.getNumeroQuizAutore(autore.getId()));
		model.addAttribute("etichetta", this.raccoltaService.getEtichettaPiuUsata(autore.getId()));
		model.addAttribute("categoria", this.quizService.getCategoriaPiuUsata(autore.getId()));

		return "dashboard.html";
	}

	// @GetMapping("/elencoQuiz")
	// public String getElencoQuiz(Model model, HttpSession session) {

	// 	if (session.getAttribute("user") == null)
	// 		return "redirect:/loginAutore";

	// 	model.addAttribute("utente", session.getAttribute("user"));
	// 	model.addAttribute("elenco",
	// 			this.autoreService.getAllQuizAutore(((Autore) session.getAttribute("user")).getId()));
	// 	model.addAttribute("categorie", categoriaService.getAllCategorie());
	// 	model.addAttribute("paginaCorrente", "elencoQuiz");

	// 	return "elencoQuiz.html";
	// }

	// @GetMapping("/elencoQuiz/{nomeCategoria}")
	// public String getElencoQuiz(Model model, HttpSession session, @PathVariable("nomeCategoria") String nomeCategoria) {

	// 	if (session.getAttribute("user") == null)
	// 		return "redirect:/loginAutore";

	// 	model.addAttribute("utente", session.getAttribute("user"));
	// 	model.addAttribute("nomeCategoria", nomeCategoria);
	// 	model.addAttribute("elenco", this.autoreService
	// 			.getAllQuizAutoreOfCategoria(((Autore) session.getAttribute("user")).getId(), nomeCategoria));
	// 	model.addAttribute("categorie", categoriaService.getAllCategorie());
	// 	model.addAttribute("paginaCorrente", "elencoQuiz/nomeCategoria");

	// 	return "elencoQuiz.html";
	// }

	// @PostMapping("/aggiuntaRaccolta")
	// public String aggiuntaNuovaRaccolta(HttpSession session, @RequestParam String nome, @RequestParam String urlImage,
	// 		@RequestParam String etichetta, @RequestParam String descrizione) {
	// 	Raccolta raccolta = new Raccolta(nome, urlImage, etichettaService.getEtichettaByNome(etichetta), descrizione,
	// 			((Autore) session.getAttribute("user")));
	// 	this.raccoltaService.saveNewRaccolta(raccolta);
	// 	return "redirect:/raccolte";
	// }

	// @PostMapping("/aggiuntaQuiz")
	// public String aggiuntaNuovoQuiz(@RequestParam("quesito") String quesito,
	// 		@RequestParam("opzioneUno") String opzioneUno, @RequestParam("opzioneDue") String opzioneDue,
	// 		@RequestParam("opzioneTre") String opzioneTre, @RequestParam("opzioneQuattro") String opzioneQuattro,
	// 		@RequestParam("idRaccolta") Long idRaccolta, @RequestParam("categoria") String categoria) {
	// 	Quiz quiz = new Quiz(quesito, opzioneUno, opzioneDue, opzioneTre, opzioneQuattro,
	// 			this.raccoltaService.getRaccoltaById(idRaccolta), categoriaService.getQuizByNome(categoria),
	// 			java.time.LocalDate.now());
	// 	this.quizService.saveNewQuiz(quiz);
	// 	return "redirect:/raccolta/" + idRaccolta;
	// }

	// // @PostMapping("/eliminazioneQuiz/")
	// // public void eliminazioneQuiz(@RequestParam Long idQuiz) {
	// // this.quizService.deleteQuiz(idQuiz);
	// // }

	// @PostMapping("/eliminazioneQuiz")
	// public ResponseEntity<String> eliminazioneQuiz(@RequestParam Long idQuiz) {
	// 	try {
	// 		this.quizService.deleteQuiz(idQuiz);
	// 		return ResponseEntity.ok("Quiz eliminato con successo");
	// 	} catch (Exception e) {
	// 		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	// 				.body("Errore durante l'eliminazione del quiz: " + e.getMessage());
	// 	}
	// }

	// // @PostMapping("/eliminazioneRaccolta/")
	// // public void eliminazioneRaccolta(@RequestParam Long idRaccolta) {
	// // this.raccoltaService.deleteRaccolta(idRaccolta);
	// // }

	// @PostMapping("/eliminazioneRaccolta")
	// public ResponseEntity<Map<String, String>> eliminazioneRaccolta(@RequestParam Long idRaccolta) {
	// 	Map<String, String> response = new HashMap<>();
	// 	try {
	// 		this.raccoltaService.deleteRaccolta(idRaccolta);
	// 		response.put("message", "Raccolta eliminata con successo");
	// 		return ResponseEntity.ok(response);
	// 	} catch (Exception e) {
	// 		response.put("error", "Errore durante l'eliminazione della raccolta: " + e.getMessage());
	// 		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	// 	}
	// }

	// @GetMapping("/raccolte")
	// public String getRaccolte(Model model, HttpSession session) {

	// 	if (session.getAttribute("user") == null)
	// 		return "redirect:/loginAutore";

	// 	model.addAttribute("utente", session.getAttribute("user"));
	// 	model.addAttribute("raccolte", ((Autore) session.getAttribute("user")).getElencoRaccolte());
	// 	Map<String, String> mappaEtichette = new HashMap<>();
	// 	for (Etichetta e : etichettaService.getAllEtichette())
	// 		mappaEtichette.put(e.getNome(), e.getNome().replace(" ", "+"));
	// 	model.addAttribute("mappaEtichette", mappaEtichette);
	// 	model.addAttribute("etichette", etichettaService.getAllEtichette());

	// 	return "raccolte.html";
	// }

	// @GetMapping("/raccolte/{nomeEtichetta}")
	// public String getRacccolteEtichetta(Model model, HttpSession session,
	// 		@PathVariable("nomeEtichetta") String nomeEtichetta) {

	// 	if (session.getAttribute("user") == null)
	// 		return "redirect:/loginAutore";

	// 	model.addAttribute("utente", session.getAttribute("user"));
	// 	model.addAttribute("nomeEtichetta", nomeEtichetta);
	// 	model.addAttribute("raccolte", this.autoreService.getAllRaccolteAutoreOfEtichetta(
	// 			((Autore) session.getAttribute("user")).getId(), nomeEtichetta.replace("+", " ")));

	// 	return "raccolte.html";
	// }

	// @GetMapping("/raccolta/{idRaccolta}")
	// public String getRaccolta(Model model, HttpSession session, @PathVariable("idRaccolta") Long idRaccolta) {

	// 	if (session.getAttribute("user") == null)
	// 		return "redirect:/loginAutore";

	// 	model.addAttribute("utente", session.getAttribute("user"));
	// 	model.addAttribute("nomeRaccolta", raccoltaService.getRaccoltaById(idRaccolta).getNome());
	// 	model.addAttribute("elenco", raccoltaService.getRaccoltaById(idRaccolta).getElencoQuiz());
	// 	model.addAttribute("categorie", categoriaService.getAllCategorie());
	// 	model.addAttribute("paginaCorrente", "raccolta");

	// 	return "raccolta.html";
	// }

	// @PostMapping("/aggiornamentoQuiz")
	// public void postAggiornamentoQuiz(@RequestParam Long idQuiz, @RequestParam String quesito,
	// 		@RequestParam String opzioneUno, @RequestParam String opzioneDue, @RequestParam String opzioneTre,
	// 		@RequestParam String opzioneQuattro, @RequestParam String categoria) {
	// 	this.quizService.updateQuiz(idQuiz, quesito, opzioneUno, opzioneDue, opzioneTre, opzioneQuattro, categoria);
	// }

	// @PostMapping("/aggiornamentoRaccolta")
	// public void postAggiornamentoRaccolta(@RequestParam Long idRaccolta, @RequestParam String nome,
	// 		@RequestParam String descrizione, @RequestParam String urlImage, @RequestParam String etichetta) {
	// 	this.raccoltaService.updateRaccolta(idRaccolta, nome, descrizione, urlImage, etichetta);
	// }

	// @GetMapping("/profilo")
	// public String getProfilo(Model model, HttpSession session) {

	// 	if (session.getAttribute("user") == null)
	// 		return "redirect:/loginAutore";

	// 	model.addAttribute("utente", session.getAttribute("user"));
	// 	model.addAttribute("raccolte", ((Autore) session.getAttribute("user")).getElencoRaccolte());
	// 	return "profilo.html";
	// }

	// @GetMapping("/impostazioni")
	// public String getImpostazioni(Model model, HttpSession session) {

	// 	if (session.getAttribute("user") == null)
	// 		return "redirect:/login";

	// 	model.addAttribute("utente", session.getAttribute("user"));
	// 	return "impostazioni.html";
	// }

	// @GetMapping("/logout")
	// public String logout(HttpSession session) {
	// 	if (session.getAttribute("user") == null)
	// 		return "redirect:/login";

	// 	session.invalidate();
	// 	return "redirect:/";

	// }
}
