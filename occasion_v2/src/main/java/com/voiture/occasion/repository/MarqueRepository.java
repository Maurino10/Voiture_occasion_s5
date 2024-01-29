package com.voiture.occasion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.voiture.occasion.model.Marque;

public interface MarqueRepository extends JpaRepository<Marque, String>{
    
}
