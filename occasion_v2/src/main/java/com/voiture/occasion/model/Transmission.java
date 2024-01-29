package com.voiture.occasion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Transmission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String idTransmission;
    String nomTransmission;

    public Transmission() {
    }
    public Transmission(String idTransmission) {
        this.idTransmission = idTransmission;
    }

    public String getIdTransmission() { return idTransmission; }

    public void setIdTransmission(String idTransmission) { this.idTransmission = idTransmission; }

    public String getNomTransmission() { return nomTransmission; }

    public void setNomTransmission(String nomTransmission) { this.nomTransmission = nomTransmission; }    
}
