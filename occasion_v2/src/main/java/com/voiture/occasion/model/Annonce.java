package com.voiture.occasion.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.voiture.occasion.helper.Utils;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Entity
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String idAnnonce;
    String idUtilisateur;
    String image;
    LocalDateTime dateAnnonce;
    
    @ManyToOne @JoinColumn(name = "id_corps")  Corps corps;
    @ManyToOne @JoinColumn(name = "id_marque")  Marque marque;
    @ManyToOne @JoinColumn(name = "id_modele")  Modele modele;
    @ManyToOne @JoinColumn(name = "id_transmission") Transmission transmission;
    @ManyToOne @JoinColumn(name = "id_moteur") Moteur moteur;
    
    String description;
    double prix;
    LocalDate annee;
    int places;
    int portes;
    double vmax;
    double consommation;
    int status;
    
    @Transient
    LocalDateTime dateValidation;
    @Transient
    int validation;
    
    
    public Annonce() {
    }

    public String getIdAnnonce() { return idAnnonce; }

    public void setIdAnnonce(String idAnnonce) { this.idAnnonce = idAnnonce; }

    public LocalDateTime getDateAnnonce() { return dateAnnonce; }

    public void setDateAnnonce(String dateAnnonce) { this.dateAnnonce = Utils.stringToDateTime(dateAnnonce); }

    public Marque getMarque() { return marque; }

    public void setMarque(Marque marque) { this.marque = marque; }

    public Modele getModele() { return modele; }

    public void setModele(Modele modele) { this.modele = modele; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public int getStatus() { return status; }

    public void setStatus(String status) { this.status = Integer.parseInt(status); }

    public void setDateAnnonce(LocalDateTime dateAnnonce) { this.dateAnnonce = dateAnnonce; }

    public int getValidation() { return validation; }

    public void setValidation(String validation) { this.validation = Integer.parseInt(validation); }

    public LocalDateTime getDateValidation() { return dateValidation; }

    public void setDateValidation(String dateValidation) { this.dateValidation = Utils.stringToDateTime(dateValidation); }

    public String getIdUtilisateur() { return idUtilisateur;  }

    public void setIdUtilisateur(String idUtilisateur) { this.idUtilisateur = idUtilisateur; }

    public Corps getCorps() { return corps; }

    public void setCorps(Corps corps) { this.corps = corps; }

    public Transmission getTransmission() { return transmission; }

    public void setTransmission(Transmission transmission) { this.transmission = transmission; }

    public Moteur getMoteur() { return moteur; }

    public void setMoteur(Moteur moteur) { this.moteur = moteur; }

    public double getPrix() { return prix; }

    public void setPrix(double prix) { this.prix = prix; }

    public LocalDate getAnnee() { return annee; }

    public void setAnnee(String annee) { this.annee = LocalDate.parse(annee); }

    public int getPortes() { return portes; }

    public void setPortes(int portes) { this.portes = portes; }
    public void setPortes(String portes) { this.portes = Integer.parseInt(portes); }

    public double getVmax() { return vmax; }

    public void setVmax(double vmax) { this.vmax = vmax; }
    public void setVmax(String vmax) { this.vmax = Double.parseDouble(vmax); }

    public double getConsommation() { return consommation; }

    public void setConsommation(double consommation) { this.consommation = consommation; }
    public void setConsommation(String consommation) { this.consommation = Double.parseDouble(consommation); }

    public int getPlaces() { return places; }

    public void setPlaces(int places) { this.places = places; }    
    public void setPlaces(String places) { this.places = Integer.parseInt(places); }

    public String getImage() {  return image; }

    public void setImage(String image) { this.image = image; }   
     
    
}
