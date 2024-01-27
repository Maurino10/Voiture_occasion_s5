package com.voiture.occasion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.voiture.occasion.config.auth.TokenProvider;
import com.voiture.occasion.model.Annonce;
import com.voiture.occasion.service.AnnonceService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;


@RestController
public class UserController {
    @Autowired
    private AnnonceService service;
    @Autowired
    private TokenProvider token;

    @PostMapping("/user/annonce")
    public Annonce createAnnonce(
        @RequestHeader(name = "Authorization") String utilisateur, 
        @RequestParam(name = "description") String description, 
        @RequestParam(name = "images") String images, 
        @RequestParam(name = "prix") String prix, 
        @RequestParam(name = "places") String places, 
        @RequestParam(name = "portes") String portes, 
        @RequestParam(name = "vmax") String vmax, 
        @RequestParam(name = "consommation") String consommation, 
        @RequestParam(name = "annee") String annee,  
        @RequestParam(name = "corps") String idCorps, 
        @RequestParam(name = "moteur") String idMoteur, 
        @RequestParam(name = "marque") String idMarque, 
        @RequestParam(name = "modele") String idModele, 
        @RequestParam(name = "transmission") String transmission
        ) {
            String idUtilisateur = token.validateToken(utilisateur.replace("Bearer ", ""));
            return service.createAnnonce(idUtilisateur, images, description, prix, places, portes, vmax, consommation, annee,  idCorps, idMarque, idModele, idMoteur, transmission);
    }

    @GetMapping("/user/annonces")
    public List<Annonce> getByUtilisateur(@RequestHeader(name = "Authorization") String utilisateur) {
        String idUtilisateur = token.validateToken(utilisateur.replace("Bearer ", ""));
        return service.getByUtilisateur(idUtilisateur);
    }

    @GetMapping("/user/historiques")
    public List<Annonce> getHistorique(@RequestHeader(name = "Authorization") String utilisateur) {
        String idUtilisateur = token.validateToken(utilisateur.replace("Bearer ", ""));
        return service.getByUtilisateur(idUtilisateur);
    }

    @PutMapping("/user/annonce/{id}")
    public ResponseEntity<String> updateStatus(@PathVariable("id") String id, @RequestParam(name = "status") String status) {
        try { service.updateStatus(id, status); } 
        catch (Exception e) { return ResponseEntity.ok("Error update"); }        
        return ResponseEntity.ok("Column update successfully");
    }

    @PostMapping("/user/favoris/{id}")
    public ResponseEntity<String> addFavoris(@PathVariable("id") String id, @RequestHeader(name = "Authorization") String utilisateur)  {
        String idUtilisateur = token.validateToken(utilisateur.replace("Bearer ", ""));
        try { service.addFavoris(id, idUtilisateur); } 
        catch (Exception e) { return ResponseEntity.ok("Error add"); }        
        return ResponseEntity.ok("Add favoris successfully");
    }
    
    @GetMapping("/user/favoris")
    public List<Annonce> getFavoris(@RequestHeader(name = "Authorization") String utilisateur) {
        String idUtilisateur = token.validateToken(utilisateur.replace("Bearer ", ""));
        return service.getByUtilisateur(idUtilisateur);
    }

        
}
