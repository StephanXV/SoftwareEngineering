#######################procedura count
DELIMITER $$
drop procedure if exists conta_zone $$

create procedure conta_zone (id_citta int) #modifica puo essere: attivo / passivo
begin 

	select COUNT(*) from zona where ID_Citta=id_citta;
    
end $$


DELIMITER $$
drop procedure if exists conta_edifici $$

create procedure conta_edifici (id_zona int) #modifica puo essere: attivo / passivo
begin 

	select COUNT(*) from EDIFICIO where ID_Zona=id_zona;
    
end $$


DELIMITER $$
drop procedure if exists conta_stanze $$

create procedure conta_stanze (id_edificio int) #modifica puo essere: attivo / passivo
begin 

	select COUNT(*) from stanza where ID_Edificio=id_edificio;
    
end $$