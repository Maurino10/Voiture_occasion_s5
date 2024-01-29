package com.voiture.occasion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Moteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String idMoteur;
    String nomMoteur;
    
    public Moteur() {
    }
    public Moteur(String idMoteur) {
        this.idMoteur = idMoteur;
    }

    public String getIdMoteur() { return idMoteur; }

    public void setIdMoteur(String idMoteur) { this.idMoteur = idMoteur; }

    public String getNomMoteur() { return nomMoteur; }

    public void setNomMoteur(String nomMoteur) { this.nomMoteur = nomMoteur; }
}
