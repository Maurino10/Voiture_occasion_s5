package com.voiture.occasion.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voiture.occasion.model.Annonce;
import com.voiture.occasion.model.Corps;
import com.voiture.occasion.model.Moteur;
import com.voiture.occasion.model.Transmission;
import com.voiture.occasion.model.Marque;
import com.voiture.occasion.model.Modele;
import com.voiture.occasion.repository.AnnonceRepository;

@Service
public class AnnonceService {
    @Autowired
    AnnonceRepository repository;
    // user
    public Annonce createAnnonce(String idUtilisateur, String image, String description, String prix, String places, String portes, String vmax, String consommation, String annee,  String idCorps, String idMarque, String idModele, String idMoteur, String transmission) {
        Annonce annonce = new Annonce();
        annonce.setDescription(description);
        annonce.setDateAnnonce(LocalDateTime.now());
        annonce.setAnnee(annee);
        annonce.setStatus("0");
        annonce.setPrix(prix);
        annonce.setPlace(places);
        annonce.setPortes(portes);
        annonce.setVmax(vmax);
        annonce.setImage(image);
        annonce.setConsommation(consommation);
        annonce.setIdUtilisateur(idUtilisateur);
        annonce.setCorps(new Corps(idCorps));
        annonce.setMarque(new Marque(idMarque));
        annonce.setModele(new Modele(idModele));
        annonce.setMoteur(new Moteur(idMoteur));
        annonce.setTransmission(new Transmission(transmission));
        return repository.save(annonce);
    }

    
    public void updateStatus(String id, String status) throws Exception {
        Optional<Annonce> annonce = repository.findById(id);
        if (annonce.isPresent()) {
            Annonce newStatus = annonce.get();
            newStatus.setStatus(status);
            repository.save(newStatus);
        } else {
            throw new Exception("Annonce is not present");
        }
    }

    public List<Annonce> getByUtilisateur(String idUtilisateur) {
        return repository.findByUtilisateur(idUtilisateur);
    }

    public void addFavoris(String idAnnonce, String idUtilisateur) {
        repository.saveFavoris(idAnnonce, idUtilisateur);
    }

    public List<Annonce> getFavoris(String idUtilisateur) {
        return repository.findFavoris(idUtilisateur);
    }
    // admin
    public void insertValidation(int etat, String idAnnonce) {
        repository.saveValidation(etat, idAnnonce);
    }

    public List<Annonce> getAllDemande() {
        return repository.findAllDemande();
    }
    
    // pubilc
    public List<Annonce> getAllValidate() {
        return repository.findAllValidate();
    }

    public List<Annonce> searchByElements(String mots, String idCoprs, String idMarque, String idModele, String idMoteur,String idTransmission) {
        
        return repository.findByElements(mots, idCoprs, idMarque, idModele, idMoteur, idTransmission);
    }

    public Optional<Annonce> findById(String id) {
        return repository.findById(id);
    }

}
