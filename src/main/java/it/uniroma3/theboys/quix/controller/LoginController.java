package it.uniroma3.theboys.quix.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;

// import ch.qos.logback.core.model.Model;
// import it.uniroma3.theboys.quix.service.AuthService;
// import jakarta.servlet.http.HttpSession;

// @Controller
// public class LoginController {

//     @Autowired
//     private AuthService authService;

//     @GetMapping("/login")
//     public String showLoginPage() {
//         return "login"; // pagina login.jsp o login.html
//     }

//     @PostMapping("/login")
//     public String login(
//             @RequestParam String username,
//             @RequestParam String password,
//             HttpSession session,
//             Model model
//     ) {
//         if (authService.autenticazione(username, password)) {
//             session.setAttribute("user", authService.getUserByUsername(username));
//             return "redirect:/dashboard";
//         } else {
//             model.addAttribute("error", "Credenziali non valide");
//             return "login";
//         }
//     }

//     @GetMapping("/logout")
//     public String logout(HttpSession session) {
//         session.invalidate();
//         return "redirect:/login";
//     }
// }
