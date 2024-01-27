package com.voiture.occasion.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.voiture.occasion.model.Utilisateur;


@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, String> {
   @Query(value = "select * from utilisateur where email = :email and mot_de_passe = :motdepasse", nativeQuery = true)
   public Optional<Utilisateur> findUtilisateur(
        @Param("email") String email,
        @Param("motdepasse") String password
   );

   public UserDetails  findByIdUtilisateur(String idUtilisateur);
}   

