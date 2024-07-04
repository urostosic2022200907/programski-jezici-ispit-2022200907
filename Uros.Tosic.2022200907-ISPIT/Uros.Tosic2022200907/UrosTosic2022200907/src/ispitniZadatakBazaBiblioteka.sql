create database ispitniZadatak;
use ispitniZadatak;
create table Biblioteka(
	id bigint auto_increment primary key,
    ime varchar(255),
    adresa varchar(255)
);
create table Knjiga(
	id bigint auto_increment primary key,
    ime varchar(255),
    cena int,
    vreme_dodavanja datetime,
    biblioteka_id bigint
);