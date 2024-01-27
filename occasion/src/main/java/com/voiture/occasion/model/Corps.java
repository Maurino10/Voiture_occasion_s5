package com.voiture.occasion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Corps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idCorps;
    private String nomCorps;

    public Corps() {
    }

    public Corps(String idCorps) {
        this.idCorps = idCorps;
    }

    public String getIdCorps() { return idCorps; }

    public void setIdCorps(String idCorps) { this.idCorps = idCorps; }

    public String getNomCorps() { return nomCorps; }

    public void setNomCorps(String nomCorps) { this.nomCorps = nomCorps; }
}
