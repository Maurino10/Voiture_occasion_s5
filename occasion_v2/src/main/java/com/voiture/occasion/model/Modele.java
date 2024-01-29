package com.voiture.occasion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Modele {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String idModele;
    String nomModele;
    @ManyToOne  @JoinColumn(name = "id_marque") Marque marque;
    @ManyToOne  @JoinColumn(name = "id_corps") Corps corps;

    public Modele() {
    }

    public Modele(String idModele) {
        this.idModele = idModele;
    }

    public String getIdModele() { return idModele; }

    public void setIdModele(String idModele) { this.idModele = idModele; }

    public String getNomModele() { return nomModele; }

    public void setNomModele(String nomModele) { this.nomModele = nomModele; }

    public Marque getMarque() { return marque; }

    public void setMarque(Marque marque) { this.marque = marque; }

    public Corps getCorps() { return corps; }

    public void setCoprs(Corps corps) { this.corps = corps; }
}
