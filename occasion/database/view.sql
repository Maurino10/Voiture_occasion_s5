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
