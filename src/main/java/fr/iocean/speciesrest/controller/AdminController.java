package fr.iocean.speciesrest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controleur pour démontrer l'utilité des rôles
 */
@RestController
@RequestMapping("/rest/admin")
public class AdminController {

    @GetMapping
    public String administerThings() {
        return "Things administered";
    }
}
