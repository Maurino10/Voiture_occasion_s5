package com.voiture.occasion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.voiture.occasion.model.Annonce;

import jakarta.transaction.Transactional;

@Repository
public interface AnnonceRepository extends JpaRepository<Annonce, String> {
    // user 

    @Query(value = "select * from annonce_validation where id_utilisateur = :idutilisateur", nativeQuery = true)
    public List<Annonce> findByUtilisateur(@Param("idutilisateur") String idUtilisateur);

    @Modifying
    @Transactional
    @Query(value = "insert into favoris (id_annonce, id_utilisateur) values (:idannonce, :idutilisateur)", nativeQuery = true)
    public void saveFavoris(@Param("idannonce") String idAnnonce, @Param("idutilisateur") String idUtilisateur);

    @Query(value = "select * from annonce_favoris where id_utilisateur = :idutilisateur", nativeQuery = true)
    public List<Annonce> findFavoris(@Param("idutilisateur") String idUtilisateur);


    // admin
    @Modifying
    @Transactional
    @Query(value = "insert into validation (etat, date, id_annonce) values (:etat, now(), :idannonce)", nativeQuery = true)
    public void saveValidation(
        @Param("etat") int etat,
        @Param("idannonce") String idAnnonce
    ); 

    @Query(value = "select * from annonce_validation where etat is null", nativeQuery = true)
    public List<Annonce> findAllDemande();
    
    // public
    @Query(value = "select * from annonce_validation where etat = 1", nativeQuery = true)
    public List<Annonce> findAllValidate();
    

    @Query(value = "select * from annonce_validation where etat = 1 and LOWER(description) LIKE LOWER(CONCAT('%',:mots,'%')) and LOWER(id_corps) LIKE LOWER(CONCAT('%',:idcorps,'%')) and LOWER(id_transmission) LIKE LOWER(CONCAT('%',:idtransmission,'%')) and LOWER(id_moteur) LIKE LOWER(CONCAT('%',:idmoteur,'%')) and LOWER(id_marque) LIKE LOWER(CONCAT('%',:idmarque,'%')) and LOWER(id_modele) LIKE LOWER(CONCAT('%',:idmodele,'%'))", nativeQuery = true)
    public List<Annonce> findByElements(
        @Param("mots") String mots,
        @Param("idmoteur") String idMoteur,
        @Param("idmarque") String idMarque,
        @Param("idmodele") String idModele,
        @Param("idcorps") String idCorps,
        @Param("idtransmission") String idTransmission
    );

    // stat
         
    @Query(value = "Select count from total_annonce", nativeQuery = true)
    public int totalAnnonce();
    
    @Query(value = "Select count from total_annonce_valider", nativeQuery = true)
    public int totalAnnonceValider();
    
    @Query(value = "Select count from total_annonce_refuser", nativeQuery = true)
    public int totalAnnonceRefuser();
    
    @Query(value = "Select count from total_annonce_reste", nativeQuery = true)
    public int totalAnnonceReste();
    
    @Query(value = "Select count from nombre_user_vendu_vehicule", nativeQuery = true)
    public int nombreUserVenduVehicule();
    
    @Query(value = "Select count from nombre_total_user", nativeQuery = true)
    public int nombreTotalUser();
    
    @Query(value = "Select count from total_vente", nativeQuery = true)
    public int totalVente();
    
    @Query(value = "Select sum from total_prix_vente", nativeQuery = true)
    public int totalPrixVente();
    
    @Query(value = "Select nom_marque from meilleur_marque", nativeQuery = true)
    public String meilleurMarque();
    
    @Query(value = "Select nom_modele from meilleur_modele", nativeQuery = true)
    public String meilleurModele();
    
    @Query(value = "Select nom_corps from meilleur_corps", nativeQuery = true)
    public String meilleurCorps(); 
    
    @Query(value = "Select nom_transmission from meilleur_transmission", nativeQuery = true)
    public String meilleurTransmission(); 
    
    @Query(value = "Select nom_moteur from meilleur_moteur", nativeQuery = true)
    public String meilleurMoteur();
}



