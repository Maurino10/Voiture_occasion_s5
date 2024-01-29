create view annonce_validation as
select 
    annonce.*,
    validation.etat,
    validation.date
from annonce 
left join validation on annonce.id_annonce = validation.id_annonce; 

create view annonce_favoris as
select 
    av.*,
    favoris.id_favoris
from favoris
left join annonce_validation as av on favoris.id_annonce = av.id_annonce;


-- STATISTIQUE
create view total_annonce as 
select 
    count(id_annonce)
from annonce;

create view total_annonce_valider as
select
    count(id_annonce)
from annonce_validation where etat = 1;

create view total_annonce_refuser as
select
    count(id_annonce)
from annonce_validation where etat = 0;

create view total_annonce_reste as 
select 
    count(id_annonce)
from annonce_validation where etat is null;

create view nombre_user_vendu_vehicule as
select 
    count(id_utilisateur) 
from (select  id_utilisateur from annonce_validation where status = 1 group by id_utilisateur) as user_vendu_vehicule;

create view nombre_total_user as
select 
    count(id_utilisateur)
from utilisateur where role = 'USER';

create view total_vente as
select 
    count(id_annonce)
from annonce_validation where status = 1;

create view total_prix_vente as
select 
    sum(prix)
from annonce_validation where status = 1;

create view meilleur_marque as
select 
    marque.nom_marque
from marque 
join (select id_marque, count(id_marque) from annonce_validation where status = 1 group by id_marque) as count on marque.id_marque = count.id_marque
order by count.count desc limit 1; 

create view meilleur_modele as
select 
    modele.nom_modele
from modele 
join (select id_modele, count(id_modele) from annonce_validation where status = 1 group by id_modele) as count on modele.id_modele = count.id_modele
order by count.count desc limit 1; 

create view meilleur_corps as
select 
    corps.nom_corps
from corps 
join (select id_corps, count(id_corps) from annonce_validation where status = 1 group by id_corps) as count on corps.id_corps = count.id_corps
order by count.count desc limit 1; 

create view meilleur_transmission as
select 
    transmission.nom_transmission
from transmission 
join (select id_transmission, count(id_transmission) from annonce_validation where status = 1 group by id_transmission) as count on transmission.id_transmission = count.id_transmission
order by count.count desc limit 1; 

create view meilleur_moteur as
select 
    moteur.nom_moteur
from moteur 
join (select id_moteur, count(id_moteur) from annonce_validation where status = 1 group by id_moteur) as count on moteur.id_moteur = count.id_moteur
order by count.count desc limit 1;

-- -- -- -- -- -- -- -- -- -- -- -- 