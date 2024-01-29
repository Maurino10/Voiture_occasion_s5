package com.voiture.occasion.model;

public class Statistique {
    int totalAnnonce;
    int totalAnnonceValider;
    int totalAnnonceRefuser;
    int totalAnnonceReste;
    int nombreUserVenduVehicule;
    int nombreTotalUser;
    int totalVente;
    int totalPrixVente;
    String meilleurMarque;
    String meilleurModele;
    String meilleurCorps;
    String meilleurTransmission;
    String meilleurMoteur;

    public Statistique() {
    }
    public int getTotalAnnonce() { return totalAnnonce; }

    public void setTotalAnnonce(int totalAnnonce) { this.totalAnnonce = totalAnnonce; }
    
    public int getTotalAnnonceValider() { return totalAnnonceValider; }

    public void setTotalAnnonceValider(int totalAnnonceValider) { this.totalAnnonceValider = totalAnnonceValider; }
    
    public int getTotalAnnonceRefuser() { return totalAnnonceRefuser; }

    public void setTotalAnnonceRefuser(int totalAnnonceRefuser) { this.totalAnnonceRefuser = totalAnnonceRefuser; }
    
    public int getTotalAnnonceReste() { return totalAnnonceReste; }

    public void setTotalAnnonceReste(int totalAnnonceReste) { this.totalAnnonceReste = totalAnnonceReste; }
    
    public int getNombreUserVenduVehicule() { return nombreUserVenduVehicule; }

    public void setNombreUserVenduVehicule(int nombreUserVenduVehicule) { this.nombreUserVenduVehicule = nombreUserVenduVehicule; }
    
    public int getNombreTotalUser() { return nombreTotalUser; }

    public void setNombreTotalUser(int nombreTotalUser) { this.nombreTotalUser = nombreTotalUser; }
    
    public int getTotalVente() { return totalVente; }

    public void setTotalVente(int totalVente) { this.totalVente = totalVente; }
    
    public int getTotalPrixVente() { return totalPrixVente; }

    public void setTotalPrixVente(int totalPrixVente) { this.totalPrixVente = totalPrixVente; }
    
    public String getMeilleurMarque() { return meilleurMarque; }

    public void setMeilleurMarque(String meilleurMarque) { this.meilleurMarque = meilleurMarque; }
    
    public String getMeilleurModele() { return meilleurModele; }

    public void setMeilleurModele(String meilleurModele) { this.meilleurModele = meilleurModele; }
    
    public String getMeilleurCorps() { return meilleurCorps; }

    public void setMeilleurCorps(String meilleurCorps) { this.meilleurCorps = meilleurCorps; }
    
    public String getMeilleurTransmission() { return meilleurTransmission; }

    public void setMeilleurTransmission(String meilleurTransmission) { this.meilleurTransmission = meilleurTransmission; }
    
    public String getMeilleurMoteur() { return meilleurMoteur; }

    public void setMeilleurMoteur(String meilleurMoteur) { this.meilleurMoteur = meilleurMoteur; }
    

    
}
