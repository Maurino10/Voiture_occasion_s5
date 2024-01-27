package com.voiture.occasion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.voiture.occasion.model.Annonce;

@Repository
public interface AnnonceRepository extends JpaRepository<Annonce, String> {
    // user 
    @Query(value = "select * from annonce_validation where id_utilisateur = :idutilisateur", nativeQuery = true)
    public List<Annonce> findByUtilisateur(@Param("idutilisateur") String idUtilisateur);

    @Query(value = "insert into favoris (id_annonce, id_utilisateur) values (:idannonce, :idutilisateur)", nativeQuery = true)
    public void saveFavoris(@Param("idannonce") String idAnnonce, @Param("idutilisateur") String idUtilisateur);

    @Query(value = "select * from annonce_favoris where id_utilisateur = :idutilisateur", nativeQuery = true)
    public List<Annonce> findFavoris(@Param("idutilisateur") String idUtilisateur);


    // admin
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

}



