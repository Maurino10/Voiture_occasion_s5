package com.voiture.occasion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.voiture.occasion.model.Annonce;
import com.voiture.occasion.model.Utilisateur;
import com.voiture.occasion.service.AnnonceService;
import com.voiture.occasion.service.UtilisateurService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class PublicController {
    @Autowired
    private AnnonceService service;
    @Autowired
    private UtilisateurService userRep;

    @GetMapping("/public/annonces")
    public List<Annonce> getALlValidates() {
        return service.getAllValidate();
    }

    @GetMapping("/public/recherche")
    public List<Annonce> getRecherche(
        @RequestParam(name = "mots") String description,
        @RequestParam(name = "idCorps") String idCoprs,
        @RequestParam(name = "idMarque") String idMarque,
        @RequestParam(name = "idModele") String idModele,
        @RequestParam(name = "idMoteur") String idMoteur,
        @RequestParam(name = "idTransmission") String idTransmission
    ) {
        return service.searchByElements(description, idCoprs, idTransmission, idMoteur, idMarque, idModele);
    }
    

    @PostMapping("/public/signup")
    public Utilisateur signUp(@RequestBody Utilisateur utilisateur) {
        return userRep.save(utilisateur);
    }

    @PostMapping("/public/signin")
    public ResponseEntity<String> signIn(@RequestParam("email") String email, @RequestParam("password") String password) {
        try {
            String token = userRep.login(email, password);
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }

    
}
