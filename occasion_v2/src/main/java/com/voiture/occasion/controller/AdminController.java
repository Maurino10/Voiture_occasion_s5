package com.voiture.occasion.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.voiture.occasion.model.Annonce;
import com.voiture.occasion.model.Corps;
import com.voiture.occasion.model.Moteur;
import com.voiture.occasion.model.Statistique;
import com.voiture.occasion.model.Transmission;
import com.voiture.occasion.model.Marque;
import com.voiture.occasion.model.Modele;
import com.voiture.occasion.repository.CorpsRepository;
import com.voiture.occasion.repository.MoteurRepository;
import com.voiture.occasion.repository.TransmissionRepository;
import com.voiture.occasion.repository.MarqueRepository;
import com.voiture.occasion.repository.ModeleRepository;
import com.voiture.occasion.service.AnnonceService;
import com.voiture.occasion.service.StatistiqueService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class AdminController {
    @Autowired
    private AnnonceService annonceRep;
    @Autowired 
    private ModeleRepository modeleRep;
    @Autowired
    private MarqueRepository marqueRep;
    @Autowired
    private CorpsRepository corpsRep;
    @Autowired
    private MoteurRepository moteurRep;
    @Autowired
    private TransmissionRepository transmissionRep;
    @Autowired
    private StatistiqueService statistiqueRep;
    
    // corps
    @PostMapping("/admin/corp")
    public Corps createCorps(@RequestBody Corps corps) {
        return corpsRep.save(corps);
    }

    @GetMapping("/admin/corps") 
    public @ResponseBody  List<Corps> getAllCorps() {
        return corpsRep.findAll();
    }

    @GetMapping("/admin/corp/{idcorps}")
    public @ResponseBody Optional<Corps> getByIdCorps(@PathVariable(name = "idcorps") String idCorps) {
        return corpsRep.findById(idCorps);
    }

    @DeleteMapping("/admin/corp/{idcorps}")
    public void deleteCorps(@PathVariable(name = "idcorps") String idCorps) {
        corpsRep.deleteById(idCorps);
    }

    // marque
    @PostMapping("/admin/marque")
    public Marque createMarque(@RequestBody Marque marque) {
        return marqueRep.save(marque);
    }

    @GetMapping("/admin/marques") 
    public @ResponseBody  List<Marque> getAllMarque() {
        return marqueRep.findAll();
    }

    @GetMapping("/admin/marque/{idmarque}")
    public @ResponseBody Optional<Marque> getByIdMarque(@PathVariable(name = "idmarque") String idMarque) {
        return marqueRep.findById(idMarque);
    }

    @DeleteMapping("/admin/marque/{idmarque}")
    public void deleteMarque(@PathVariable(name = "idmarque") String idMarque) {
        marqueRep.deleteById(idMarque);
    }

    // modele
    @PostMapping("/admin/modele")
    public Modele createModele(@RequestBody Modele modele) {
        return  modeleRep.save(modele);
    }

    @GetMapping("/admin/modeles")
    public @ResponseBody List<Modele> getAllModele(){
        return modeleRep.findAll();
    }

    @GetMapping("/admin/modele/{idmodele}")
    public @ResponseBody Optional<Modele> getByIdModele(@PathVariable(name = "idmodele") String idModele){
        return modeleRep.findById(idModele);
    }

    @DeleteMapping("/admin/modele/{idmodele}")
    public void deleteModele(@PathVariable(name = "idmodele") String idModele) {
        modeleRep.deleteById(idModele);
    }

    // moteur    
    @PostMapping("/admin/moteur")
    public Moteur createMoteur(@RequestBody Moteur moteur) {
        return moteurRep.save(moteur);
    }

    @GetMapping("/admin/moteurs") 
    public @ResponseBody  List<Moteur> getAllMoteur() {
        return moteurRep.findAll();
    }

    @GetMapping("/admin/moteur/{idmoteur}")
    public @ResponseBody Optional<Moteur> getByIdMoteur(@PathVariable(name = "idmoteur") String idMoteur) {
        return moteurRep.findById(idMoteur);
    }

    @DeleteMapping("/admin/moteur/{idmoteur}")
    public void deleteMoteur(@PathVariable(name = "idmoteur") String idModele) {
        moteurRep.deleteById(idModele);
    }

    // transmission
    @PostMapping("/admin/transmission")
    public Transmission createTransmission(@RequestBody Transmission transmission) {
        return transmissionRep.save(transmission);
    }

    @GetMapping("/admin/transmissions") 
    public @ResponseBody  List<Transmission> getAllTransmission() {
        return transmissionRep.findAll();
    }

    @GetMapping("/admin/transmission/{idtransmission}")
    public @ResponseBody Optional<Transmission> getByIdTransmission(@PathVariable(name = "idtransmission") String idTransmission) {
        return transmissionRep.findById(idTransmission);
    }

    @DeleteMapping("/admin/transmission/{idtransmission}")
    public void deleteTransmission(@PathVariable(name = "idtransmission") String idTransmission) {
        transmissionRep.deleteById(idTransmission);
    }

    // annonce 
    @PostMapping("/admin/annonce/{idannonce}/{etat}")
    public Optional<Annonce> insertValidation(@PathVariable(name = "idannonce") String id, @PathVariable(name = "etat") int etat) {
        return annonceRep.insertValidation(etat, id);
    }

    @GetMapping("/admin/annonces")
    public List<Annonce> getAllDemande() {
        return annonceRep.getAllDemande();
    }

    // stat
    @GetMapping("/admin/stats")
    public Statistique getStatistique() {
        return statistiqueRep.getStatistique();
    }
    
    
    
}
