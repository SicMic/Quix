package it.uniroma3.theboys.quix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.theboys.quix.model.Autore;
import it.uniroma3.theboys.quix.model.Utente;
import it.uniroma3.theboys.quix.service.AuthServiceAutore;
import it.uniroma3.theboys.quix.service.AuthServiceUtente;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private AuthServiceAutore authServiceAutore;

    @Autowired
    private AuthServiceUtente authServiceUtente;

    // @GetMapping("/loginUtente")
    // public String showLoginPage(Model model) {
    //     model.addAttribute("utente", new Utente());
    //     return "loginUtente.html"; // pagina login.jsp o login.html
    // }

    // @PostMapping("/loginUtente")
    // public String loginUtente(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
    //     if (authServiceUtente.autenticazione(username, password)) {
    //         session.setAttribute("user", authServiceUtente.getUserByUsername(username));
    //         session.setMaxInactiveInterval(60*30);                                           //timeout sessione dopo 5 minuti
    //         model.addAttribute("utente", session.getAttribute("user"));
    //         return "redirect:/dashboardUtente";
    //     } else {
    //         model.addAttribute("error", "Credenziali non valide");
    //         return "redirect:/loginUtente";
    //     }
    // }

    // @GetMapping("/loginAutore")
    // public String showLoginPageAutore(Model model) {
    //     model.addAttribute("autore", new Autore());
    //     return "loginAutore.html"; // pagina login.jsp o login.html
    // }

    // @PostMapping("/loginAutore")
    // public String loginAutore(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
    //     if (authServiceAutore.autenticazione(username, password)) {
    //         session.setAttribute("user", authServiceAutore.getAutoreByUsername(username));
    //         session.setMaxInactiveInterval(60*30);                                           //timeout sessione dopo 5 minuti
    //         model.addAttribute("utente", session.getAttribute("user"));
    //         return "redirect:/dashboardAutore";
    //     } else {
    //         model.addAttribute("error", "Credenziali non valide");
    //         return "redirect:/loginAutore";
    //     }
    // }

    // @GetMapping("/logout")
    // public String logout(HttpSession session) {
    //     session.invalidate();
    //     return "redirect:/login";
    // }
}
