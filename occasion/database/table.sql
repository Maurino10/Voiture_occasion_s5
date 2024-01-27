create sequence seq_utilisateur;
create table utilisateur (
    id_utilisateur varchar(20) not null default concat('USR' || LPAD(nextval('seq_utilisateur')::text, 5, '0')),
    nom_utilisateur varchar(50) not null,
    email varchar(50) not null,
    mot_de_passe varchar(10) not null,
    role varchar(20) not null,

    primary key (id_utilisateur)
);
alter table utilisateur alter column mot_de_passe type varchar(15);

create sequence seq_corps;
create table corps (
    id_corps varchar(20) not null default concat('CRP' || LPAD(nextval('seq_corps')::text, 5, '0')),
    nom_corps varchar(50) not null,
    
    primary key (id_corps)
);



create sequence seq_marque;
create table marque (
    id_marque varchar(20) not null default concat('MRQ' || LPAD(nextval('seq_marque')::text , 5, '0')),
    nom_marque varchar(50) not null,

    primary key (id_marque)
);

create sequence seq_modele;
create table modele (
    id_modele varchar(20) not null default concat('MDL' || LPAD(nextval('seq_modele')::text, 5, '0')),
    nom_modele varchar(50),
    id_marque varchar(20) references marque(id_marque),
    id_corps varchar(20) references corps(id_corps),

    primary key (id_modele)
);

create sequence seq_moteur;
create table moteur (
    id_moteur varchar(20) not null default concat('MTR' || LPAD(nextval('seq_moteur')::text , 5, '0')),
    nom_moteur varchar(50) not null,

    primary key (id_moteur)
);

create sequence seq_transmission;
create table transmission (
    id_transmission varchar(20) not null default concat('TRSM' || LPAD(nextval('seq_transmission')::text , 5, '0')),
    nom_transmission varchar(50) not null,

    primary key (id_transmission)
);

create sequence seq_annonce;
create table annonce (
    id_annonce varchar(20) not null default concat('ANC' || LPAD(nextval('seq_annonce')::text , 10, '0')),
    date_annonce timestamp,
    image varchar(255),
    description varchar(255),
    prix varchar(20),
    places int,
    portes int,
    vmax double precision,
    consommation double precision,
    annee date,
    status int,
    id_utilisateur varchar(20) references utilisateur(id_utilisateur),
    id_corps varchar(20) references corps(id_corps),
    id_marque varchar(20) references marque(id_marque),
    id_modele varchar(20) references modele(id_modele),
    id_moteur varchar(20)  references moteur(id_moteur),
    id_transmission varchar(20) references transmission(id_transmission),

    primary key (id_annonce)
);

create table validation (
    id_etat serial,
    etat int,
    date timestamp,
    id_annonce varchar(20) references annonce(id_annonce),

    primary key(id_etat)
);
 
create sequence seq_favoris;
create table favoris (
    id_favoris varchar(20) not null default concat('FV' || LPAD(nextval('seq_favoris')::text, 10, '0')),
    id_annonce varchar(20) references annonce(id_annonce), 
    id_utilisateur varchar(20) references utilisateur(id_utilisateur),

    primary key (id_favoris)
);


-- alter table annonce add column etat int;
 insert into marque (nom_marque) values
 ('Volkswagen');
 insert into corps (nom_corps) values
 ('Plaisir');
 insert into modele (nom_modele, id_marque, id_corps) values
 ('GTI', 'MRQ00001', 'CRP00001');
 insert into moteur (nom_moteur) values
 ('Essence');
 insert into transmission (nom_transmission) values
 ('Automatique');

 insert into annonce (image, description, annee, prix, places, portes, vmax, consommation, id_transmission, id_moteur, id_corps, id_marque, id_modele) values
 ('image.png','5places, bon etat, freinage abs, 4 cylindres,essence','2015-01-01', '25Milliards Ar', 5, 4, 150, 10, 'TRSM00001', 'MTR00001', 'CRP00001', 'MRQ00001', 'MDL00001');