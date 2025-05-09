package it.uniroma3.theboys.quix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.theboys.quix.model.Utente;
import it.uniroma3.theboys.quix.service.AuthService;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private AuthService authService;

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("utente", new Utente());
        return "login.html"; // pagina login.jsp o login.html
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
        if (authService.autenticazione(username, password)) {
            session.setAttribute("user", authService.getUserByUsername(username));
            session.setMaxInactiveInterval(60*5);                                           //timeout sessione dopo 5 minuti
            model.addAttribute("utente", session.getAttribute("user"));
            return "redirect:/dashboard";
        } else {
            model.addAttribute("error", "Credenziali non valide");
            return "redirect:/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
