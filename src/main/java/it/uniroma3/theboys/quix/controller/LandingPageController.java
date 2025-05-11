package it.uniroma3.theboys.quix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LandingPageController {

    @GetMapping("/index")
    public String getIndex(Model model) {
        return "index.html"; 
    }
}
