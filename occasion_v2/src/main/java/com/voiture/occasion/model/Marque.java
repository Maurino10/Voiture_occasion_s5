package com.voiture.occasion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Marque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String idMarque;
    String nomMarque;

    public Marque() {
    }
    
    public Marque(String idMarque) {
        this.idMarque = idMarque;
    }

    public String getIdMarque() { return idMarque; }

    public void setIdMarque(String idMarque) { this.idMarque = idMarque; }

    public String getNomMarque() { return nomMarque; }

    public void setNomMarque(String nomMarque) { this.nomMarque = nomMarque; }
}
