package it.uniroma3.theboys.quix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.theboys.quix.model.Autore;
import it.uniroma3.theboys.quix.service.AuthServiceAutore;
import it.uniroma3.theboys.quix.service.AutoreService;
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

    
    @GetMapping("/registrazioneAutore")
		public String getRegistrazione(Model model) {
        model.addAttribute("utente", new Autore());
		return "registrazioneAutore.html";
  	}

    @PostMapping("/registrazioneAutore")
  	public String newRegistrazione(@ModelAttribute("utente") Autore autore, HttpSession session, Model model) {
        this.autoreService.saveNewAutore(autore);
		// session.setAttribute("user", authServiceAutore.getAutoreByUsername(autore.getUsername()));
        // session.setMaxInactiveInterval(60*5);                                          
        // model.addAttribute("utente", session.getAttribute("user"));
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
		model.addAttribute("elenco", ((Autore) session.getAttribute("user")).getElencoQuiz());
		return "elencoQuiz.html";
	}

	@PostMapping("/eliminazioneQuiz/{idQuiz}")
	public void eliminazioneQuiz(Model model, @RequestParam Integer idQuiz) {
		//REMOVE QUIZ CON SERVICE
	}


	@GetMapping("/raccolte")
	public String getRaccolte(Model model, HttpSession session) {

		if (session.getAttribute("user") == null)
			return "redirect:/loginAutore";

		model.addAttribute("utente", session.getAttribute("user"));
		model.addAttribute("raccolte", ((Autore) session.getAttribute("user")).getElencoRaccolte());
		return "raccolte.html";
	}

	@GetMapping("/raccolta/{idRaccolta}")
	public String getRaccolta(Model model, HttpSession session, @PathVariable Long idRaccolta) {

		if (session.getAttribute("user") == null)
			return "redirect:/loginAutore";

		model.addAttribute("utente", session.getAttribute("user"));
		model.addAttribute("nomeRaccolta", raccoltaService.getRaccoltaById(idRaccolta).getNome());
		model.addAttribute("elenco", raccoltaService.getRaccoltaById(idRaccolta).getElencoQuiz());
		return "raccolta.html";
	}

	@GetMapping("/creaQuiz")
	public String getCreaQuiz(Model model, HttpSession session) {

		if (session.getAttribute("user") == null)
			return "redirect:/loginAutore";

		model.addAttribute("utente", session.getAttribute("user"));
		model.addAttribute("raccolte", ((Autore) session.getAttribute("user")).getElencoRaccolte());
		return "creaQuiz.html";
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

}
