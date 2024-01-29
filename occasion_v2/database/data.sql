insert into utilisateur (nom_utilisateur, email, mot_de_passe, role) values
 ('admin', 'admin@gmail.com', 'admin', 'ADMIN'),
 ('user', 'user@gmail.com', 'user', 'USER');

insert into marque (nom_marque) values
 ('Toyota'),
 ('Ford'),
 ('BMW'),
 ('Honda'),
 ('Mercedes-Benz');

insert into corps (nom_corps) values
 ('Plaisir'),
 ('4X4'),
 ('Camion');

 insert into modele (nom_modele, id_marque, id_corps) values
 ('Toyota Camry', 'MRQ00001', 'CRP00001'),
 ('Toyota Corolla', 'MRQ00001', 'CRP00001'),
 ('Toyota RAV4', 'MRQ00001', 'CRP00002');

insert into moteur (nom_moteur) values
 ('Electrique'),
 ('Diesel'),
 ('Essence');

insert into transmission (nom_transmission) values
 ('Automatique'),
 ('Manuelle');

insert into annonce (id_utilisateur, image, description, annee, prix, places, portes, vmax, consommation, id_transmission, id_moteur, id_corps, id_marque, id_modele, status) values
 ('USR00001', 'image.png', '5places, bon etat, freinage abs, 4 cylindres,essence','2015-01-01', 25000000, 5, 4, 150, 10, 'TRSM00002', 'MTR00003', 'CRP00001', 'MRQ00001', 'MDL00001', 0),
 ('USR00001', 'image.png', '5places, bon etat, freinage abs, 4 cylindres,essence','2015-01-01', 25000000, 5, 4, 150, 10, 'TRSM00001', 'MTR00001', 'CRP00001', 'MRQ00001', 'MDL00001', 0),
 ('USR00001', 'image.png', '5places, bon etat, freinage abs, 4 cylindres,essence','2015-01-01', 25000000, 5, 4, 150, 10, 'TRSM00002', 'MTR00002', 'CRP00002', 'MRQ00001', 'MDL00003', 0);

insert into validation (etat, date, id_annonce) values 
(1, now(), 'ANC0000000004'),
(1, now(), 'ANC0000000001'),
(0, now(), 'ANC0000000002');

update annonce set status = 1 where id_annonce = 'ANC0000000004';