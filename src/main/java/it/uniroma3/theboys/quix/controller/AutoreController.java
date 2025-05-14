package it.uniroma3.theboys.quix.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.theboys.quix.model.Autore;
import it.uniroma3.theboys.quix.model.Etichetta;
import it.uniroma3.theboys.quix.model.Quiz;
import it.uniroma3.theboys.quix.model.Raccolta;
import it.uniroma3.theboys.quix.repository.CategoriaRepository;
import it.uniroma3.theboys.quix.repository.EtichettaRepository;
import it.uniroma3.theboys.quix.service.AuthServiceAutore;
import it.uniroma3.theboys.quix.service.AutoreService;
import it.uniroma3.theboys.quix.service.EtichettaService;
import it.uniroma3.theboys.quix.service.QuizService;
import it.uniroma3.theboys.quix.service.RaccoltaService;
import jakarta.servlet.http.HttpSession;


@Controller
public class AutoreController {

	/*  Verificare la correttezza dell'utilizzo di repository di entità al posto di service  */

	@Autowired private AutoreService autoreService;

	@Autowired private RaccoltaService raccoltaService;

	@Autowired private AuthServiceAutore authServiceAutore;

	@Autowired private QuizService quizService;

	@Autowired private EtichettaRepository etichettaRepository;
	@Autowired private EtichettaService etichettaService;

	@Autowired private CategoriaRepository categoriaRepository;

    
    @GetMapping("/registrazioneAutore")
		public String getRegistrazione(Model model) {
        model.addAttribute("utente", new Autore());
		return "registrazioneAutore.html";
  	}

    @PostMapping("/registrazioneAutore")
  	public String newRegistrazione(@ModelAttribute("utente") Autore autore, HttpSession session, Model model) {
        this.autoreService.saveNewAutore(autore);
		session.setAttribute("user", authServiceAutore.getAutoreByUsername(autore.getUsername()));
        session.setMaxInactiveInterval(60*5);                                          
        model.addAttribute("utente", session.getAttribute("user"));
        return "redirect:dashboardAutore"; // modificare in base a struttura url dashboard
	}

	@GetMapping("/loginAutore")
	public String getLoginAutore(Model model) {
		model.addAttribute("autore", new Autore());
		return "loginAutore.html"; // pagina login.jsp o login.html
	}

	@PostMapping("/loginAutore")
	public String loginAutore(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
		if (authServiceAutore.autenticazione(username, password)) {
			session.setAttribute("user", authServiceAutore.getAutoreByUsername(username));
			session.setMaxInactiveInterval(60 * 30); // timeout sessione dopo 5 minuti
			model.addAttribute("utente", session.getAttribute("user"));
			return "redirect:/dashboardAutore";
		} else {
			model.addAttribute("error", "Credenziali non valide");
			return "redirect:/loginAutore";
		}
	}

	@GetMapping("/dashboardAutore")
	public String getDashboard(Model model, HttpSession session) {

		if (session.getAttribute("user") == null)
			return "redirect:/loginAutore";

		model.addAttribute("utente", session.getAttribute("user"));
		model.addAttribute("raccolte", ((Autore) session.getAttribute("user")).getElencoRaccolte());
		return "dashboardAutore.html";
	}

	@GetMapping("/elencoQuiz")
	public String getElencoQuiz(Model model, HttpSession session) {

		if (session.getAttribute("user") == null)
			return "redirect:/loginAutore";

		model.addAttribute("utente", session.getAttribute("user"));
		model.addAttribute("elenco", this.autoreService.getAllQuizAutore(((Autore) session.getAttribute("user")).getId()));
		return "elencoQuiz.html";
	}

	@GetMapping("/elencoQuiz/{nomeCategoria}")
	public String getElencoQuiz(Model model, HttpSession session, @PathVariable("nomeCategoria") String nomeCategoria) {

		if (session.getAttribute("user") == null)
			return "redirect:/loginAutore";

		model.addAttribute("utente", session.getAttribute("user"));
		model.addAttribute("nomeCategoria", nomeCategoria);
		model.addAttribute("elenco", this.autoreService.getAllQuizAutoreOfCategoria(((Autore) session.getAttribute("user")).getId(),nomeCategoria));
		return "elencoQuiz.html";
	}


	// ----- attenzione a etichetta @RequestParam
	@PostMapping("/aggiuntaRaccolta")
	public void aggiuntaNuovaRaccolta(@RequestParam String nomeRaccolta, @RequestParam String urlImage, @RequestParam String etichetta, @RequestParam String descrizione){
		Raccolta raccolta = new Raccolta(nomeRaccolta, urlImage, etichettaRepository.findEtichettaByNome(etichetta), descrizione);
		this.raccoltaService.save(raccolta);
	}


	@PostMapping("/aggiuntaQuiz")
	public String aggiuntaNuovoQuiz(@RequestParam("quesito") String quesito, @RequestParam("opzioneUno") String opzioneUno, @RequestParam("opzioneDue") String opzioneDue, @RequestParam("opzioneTre") String opzioneTre, @RequestParam("opzioneQuattro") String opzioneQuattro, @RequestParam("idRaccolta") Long idRaccolta, @RequestParam("categoria") String categoria){
		Quiz quiz = new Quiz(quesito, opzioneUno, opzioneDue, opzioneTre, opzioneQuattro, this.raccoltaService.getRaccoltaById(idRaccolta), categoriaRepository.findCategoriaByNome(categoria), java.time.LocalDate.now());
		this.quizService.save(quiz);
		return "redirect:/raccolta/" + idRaccolta;
	}



	@PostMapping("/eliminazioneQuiz/")
	public void eliminazioneQuiz(@RequestParam Long idQuiz) {
		this.quizService.deleteQuiz(idQuiz);
	}

	@GetMapping("/raccolte")
	public String getRaccolte(Model model, HttpSession session) {

		if (session.getAttribute("user") == null)
			return "redirect:/loginAutore";

		model.addAttribute("utente", session.getAttribute("user"));
		model.addAttribute("raccolte", ((Autore) session.getAttribute("user")).getElencoRaccolte());
		Map<String, String> mappaEtichette = new HashMap<>();
		for(Etichetta e : etichettaService.getAllEtichette())
			mappaEtichette.put(e.getNome(), e.getNome().replace(" ", "+"));
		model.addAttribute("mappaEtichette", mappaEtichette);
		model.addAttribute("etichette", etichettaService.getAllEtichette());

		return "raccolte.html";
	}

	@GetMapping("/raccolte/{nomeEtichetta}")
	public String getRacccolteEtichetta(Model model, HttpSession session, @PathVariable("nomeEtichetta") String nomeEtichetta) {

		if (session.getAttribute("user") == null)
			return "redirect:/loginAutore";

		model.addAttribute("utente", session.getAttribute("user"));
		model.addAttribute("nomeEtichetta", nomeEtichetta);
		model.addAttribute("raccolte", this.autoreService.getAllRaccolteAutoreOfEtichetta(((Autore) session.getAttribute("user")).getId(), nomeEtichetta.replace("+", " ")));
		return "raccolte.html";
	}

	@GetMapping("/raccolta/{idRaccolta}")
	public String getRaccolta(Model model, HttpSession session, @PathVariable("idRaccolta") Long idRaccolta) {

		if (session.getAttribute("user") == null)
			return "redirect:/loginAutore";

		model.addAttribute("utente", session.getAttribute("user"));
		model.addAttribute("nomeRaccolta", raccoltaService.getRaccoltaById(idRaccolta).getNome());
		model.addAttribute("elenco", raccoltaService.getRaccoltaById(idRaccolta).getElencoQuiz());
		model.addAttribute("categorie", categoriaRepository.findAll());
		return "raccolta.html";
	}

	@PostMapping("/aggiornamentoQuiz")
	public void postAggiornamentoQuiz(@RequestParam Long idQuiz, @RequestParam String quesito, @RequestParam String opzioneUno, @RequestParam String opzioneDue, @RequestParam String opzioneTre, @RequestParam String opzioneQuattro) {
		this.quizService.updateQuiz(idQuiz, quesito, opzioneUno, opzioneDue, opzioneTre, opzioneQuattro);
	}

	@GetMapping("/profilo")
	public String getProfilo(Model model, HttpSession session) {

		if (session.getAttribute("user") == null)
			return "redirect:/loginAutore";

		model.addAttribute("utente", session.getAttribute("user"));
		model.addAttribute("raccolte", ((Autore) session.getAttribute("user")).getElencoRaccolte());
		return "profilo.html";
	}

	@GetMapping("/impostazioni")
	public String getImpostazioni(Model model, HttpSession session) {

		if (session.getAttribute("user") == null)
			return "redirect:/login";

		model.addAttribute("utente", session.getAttribute("user"));
		return "impostazioni.html";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session){
		if (session.getAttribute("user") == null)
			return "redirect:/login";
		
		session.invalidate();
		return "redirect:/";

	}
}
