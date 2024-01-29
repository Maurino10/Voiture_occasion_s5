create sequence seq_utilisateur;
create table utilisateur (
    id_utilisateur varchar(20) not null default concat('USR' || LPAD(nextval('seq_utilisateur')::text, 5, '0')),
    nom_utilisateur varchar(50) not null,
    email varchar(50) not null,
    mot_de_passe varchar(15) not null,
    role varchar(20) not null,

    primary key (id_utilisateur)
);


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
    prix double precision,
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

alter table annonce alter column prix type double precision using prix::double precision;
