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
    public Annonce createAnnonce(Annonce annonce) {
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

    public Optional<Annonce> getByIdAnnonce(String idAnnonce) {
        return repository.findById(idAnnonce);
    }

    public Optional<Annonce> addFavoris(String idAnnonce, String idUtilisateur) {
        repository.saveFavoris(idAnnonce, idUtilisateur);
        return repository.findById(idAnnonce);
    }

    public List<Annonce> getFavoris(String idUtilisateur) {
        return repository.findFavoris(idUtilisateur);
    }
    // admin
    public Optional<Annonce> insertValidation(int etat, String idAnnonce) {
        repository.saveValidation(etat, idAnnonce);
        return repository.findById(idAnnonce);
    }

    public List<Annonce> getAllDemande() {
        return repository.findAllDemande();
    }
    
    // pubilc
    public List<Annonce> getAllValidate() {
        return repository.findAllValidate();
    }

    public List<Annonce> searchByElements(String description, String idCoprs, String idMarque, String idModele, String idMoteur,String idTransmission) {
        return repository.findByElements(description, idCoprs, idTransmission, idMoteur, idMarque, idModele);
    }

    public Optional<Annonce> findById(String id) {
        return repository.findById(id);
    }

}
