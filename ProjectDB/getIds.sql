#######################procedura count
DELIMITER $$
drop procedure if exists getIdCitta $$

create procedure getIdCitta (usern varchar(100)) #modifica puo essere: attivo / passivo
begin 

	select c.ID from (Citta as c inner join (select u.ID from Utente as u where u.username = usern) as u1 on c.ID_gestore=u1.ID);
    
end $$


DELIMITER $$
drop procedure if exists getIdZona $$

create procedure getIdZona (usern varchar(100)) #modifica puo essere: attivo / passivo
begin 

	select z.ID from (Zona as z inner join (select u.ID from Utente as u where u.username = usern) as u1 on z.ID_gestore=u1.ID);
    
end $$


DELIMITER $$
drop procedure if exists getIdEdificio $$

create procedure getIdEdificio (usern varchar(100)) #modifica puo essere: attivo / passivo
begin 

	select e.ID from (Edificio as e inner join (select u.ID from Utente as u where u.username = usern) as u1 on e.ID_gestore=u1.ID);
    
end $$