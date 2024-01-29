package com.voiture.occasion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.voiture.occasion.model.Moteur;

@Repository
public interface MoteurRepository extends JpaRepository<Moteur, String> {
    
}
