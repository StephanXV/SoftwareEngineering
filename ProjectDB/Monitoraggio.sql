drop database if exists Monitoraggio;

/* Creazione del Database */

create database Monitoraggio;
use Monitoraggio;

create table Utente(
ID integer unsigned not null primary key auto_increment,
nome varchar(200) not null, 
cognome varchar(200) not null,
numero_telefono long not null,
tipo enum ('Edificio', 'Zona', 'Citta', 'Amministratore') not null,
username varchar(50) not null unique,
pass_word varchar(50) not null
);

create table Citta(
ID integer unsigned not null primary key auto_increment,
nome varchar(16) not null,
ID_gestore integer unsigned not null,
constraint gestore_citta foreign key (ID_gestore) references Utente(ID)
);

create table Zona(
ID integer unsigned not null primary key auto_increment,
nome varchar(16) not null,
ID_gestore integer unsigned not null,
ID_citta integer unsigned not null,
constraint gestore_zona foreign key (ID_gestore) references utente(ID),
constraint citta_zona foreign key (ID_citta) references Citta(ID)
);

create table Edificio(
ID integer unsigned not null primary key auto_increment,
nome varchar(30) not null,
ID_gestore integer unsigned not null,
ID_Zona integer unsigned not null,
constraint gestore_Edificio foreign key (ID_gestore) references utente(ID),
constraint zona_Edificio foreign key (ID_Zona) references Zona(ID)
);

create table Valori_Associati(
ID integer unsigned not null primary key auto_increment,
Min_ValueTemperatura double unsigned not null,
Max_ValueTemperatura double unsigned not null,
Min_ValuePressione double unsigned not null,
Max_ValuePressione double unsigned not null,
Min_ValueUmidita double unsigned not null,
Max_ValueUmidita double unsigned not null,
Min_ValueLuminosita double unsigned not null,
Max_ValueLuminosita double unsigned not null
);

create table Stanza(
ID integer unsigned not null primary key auto_increment,
nome varchar(16) not null,
piano integer unsigned not null,
ID_ValoriAssociati integer unsigned not null,
priorita enum ('low', 'medium', 'high') not null,
allerta integer(1) unsigned not null default 0,
ID_edificio integer unsigned not null,
constraint Stanza_Valori foreign key (ID_ValoriAssociati) references Valori_Associati(ID),
constraint Stanza_Edificio foreign key (ID_edificio) references Edificio(ID)
);

create table Sensore(
ID integer unsigned not null primary key auto_increment,
codice varchar(16) not null unique default 'T4',
tipo enum ('umidita', 'pressione', 'luminosita', 'temperatura') not null,
stato integer(1) unsigned not null,
ID_Stanza integer unsigned not null,
constraint Stanza_sensore foreign key (ID_Stanza) references Stanza(ID)
);

create table Valore(
ID_Sensore integer unsigned not null primary key,
valore_percepito double not null,
time_stamp timestamp not null default current_timestamp,
constraint valore_sensore foreign key (ID_Sensore) references Sensore(ID)
);

##################### insert utente
insert into Utente (nome,cognome,numero_telefono,tipo,username,pass_word) values
				   ("fabrizio","pavan",12345,"Edificio","pavan05","iosonogay");
                   
insert into Utente (nome,cognome,numero_telefono,tipo,username,pass_word) values
				   ("paolo","ialacci",344444,"Citta","iala05","iosonogay");
                   
insert into Utente (nome,cognome,numero_telefono,tipo,username,pass_word) values
				   ("pippo","baudo",65657474,"Amministratore","baudo05","iosonogay");
                   
insert into Utente (nome,cognome,numero_telefono,tipo,username,pass_word) values
				   ("stefan","flower",12345,"Zona","leviatanus05","iosonogay");
                   

###################### insert città
insert into Citta (nome,ID_gestore) values
				   ("L'Aquila",2);


##################### insert zona
insert into Zona (nome,ID_gestore,ID_citta) values
				   ("Coppito",4,1);
                   

#####################insert edificio
insert into Edificio (nome,ID_gestore,ID_zona) values
				   ("Blocco0",1,1);
                   
                   
                   
###################insert stanza
insert into Stanza (nome,piano, ID_ValoriAssociati, priorita, ID_edificio) values
				   ("a1.6",1,1,"low",1);
                   
insert into Stanza (nome,piano, ID_ValoriAssociati, priorita, ID_edificio) values
				   ("a1.7",1,1,"low",1);
                   
insert into Stanza (nome,piano, ID_ValoriAssociati, priorita, ID_edificio) values
				   ("a1.8",1,1,"low",1);
                   
insert into Stanza (nome,piano, ID_ValoriAssociati, priorita, ID_edificio) values
				   ("a1.9",1,1,"low",1);

insert into Stanza (nome,piano, ID_ValoriAssociati, priorita, ID_edificio) values
				   ("a1.10",1,1,"low",1);
   
insert into Stanza (nome,piano, ID_ValoriAssociati, priorita, ID_edificio) values
				   ("a2.0",2,1,"low",1);
   
insert into Stanza (nome,piano, ID_ValoriAssociati, priorita, ID_edificio) values
				   ("a2.1",2,1,"low",1);
   
insert into Stanza (nome,piano, ID_ValoriAssociati, priorita, ID_edificio) values
				   ("a2.2",2,1,"low",1);

insert into Stanza (nome,piano, ID_ValoriAssociati, priorita, ID_edificio) values
				   ("a2.3",2,1,"low",1);
   
insert into Stanza (nome,piano, ID_ValoriAssociati, priorita, ID_edificio) values
				   ("a2.4",2,1,"low",1);
   
   
                   
                   
########################procedura login
DELIMITER $$
drop procedure if exists verifica_utente $$

create procedure verifica_utente (usern varchar (100), pass varchar(100)) #modifica puo essere: attivo / passivo
begin 
    
    if pass is null or usern is null then
		signal sqlstate '45000' set message_text = 'errore: inserire tutti i dati richiesti';
	end if;	#controlla che l'utente esista
    
    if not exists (select u.ID from Utente as u where u.username like usern and u.pass_word like pass) then
	signal sqlstate '45000' set message_text='inserire email e password valide';
    end if;
    

	select tipo from Utente where (username=usern and pass_word=pass);
    
end $$







