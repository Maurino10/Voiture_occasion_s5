package com.voiture.occasion.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.voiture.occasion.model.Corps;

@Repository
public interface CorpsRepository extends JpaRepository<Corps, String> {
    
}
