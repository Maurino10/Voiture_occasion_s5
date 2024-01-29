package com.voiture.occasion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.voiture.occasion.model.Transmission;

@Repository
public interface TransmissionRepository extends JpaRepository<Transmission, String> {
    
}
