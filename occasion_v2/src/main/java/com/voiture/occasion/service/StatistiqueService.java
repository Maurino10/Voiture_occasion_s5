package com.voiture.occasion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voiture.occasion.model.Statistique;
import com.voiture.occasion.repository.AnnonceRepository;

@Service
public class StatistiqueService {
    @Autowired
    AnnonceRepository repository;

    public Statistique getStatistique() {
        Statistique stat = new Statistique();
        stat.setTotalAnnonce(repository.totalAnnonce());
        stat.setTotalAnnonceValider(repository.totalAnnonceValider());
        stat.setTotalAnnonceRefuser(repository.totalAnnonceRefuser());
        stat.setTotalAnnonceReste(repository.totalAnnonceReste());
        stat.setNombreUserVenduVehicule(repository.nombreUserVenduVehicule());
        stat.setNombreTotalUser(repository.nombreTotalUser());
        stat.setTotalVente(repository.totalVente());
        stat.setTotalPrixVente(repository.totalPrixVente());
        stat.setMeilleurMarque(repository.meilleurMarque());
        stat.setMeilleurModele(repository.meilleurModele());
        stat.setMeilleurCorps(repository.meilleurCorps());
        stat.setMeilleurTransmission(repository.meilleurTransmission());
        stat.setMeilleurMoteur(repository.meilleurMoteur());
        return stat;
    }
}
