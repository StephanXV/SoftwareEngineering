DELIMITER $$
drop procedure if exists verifica_utente $$

create procedure verifica_utente (usern varchar (100), pass varchar(100)) #modifica puo essere: attivo / passivo
begin 
    
    if pass is null or usern is null then
		signal sqlstate '45000' set message_text = 'errore: inserire tutti i dati richiesti';
	end if;	#controlla che l'utente esista*/
    
    if not exists (select u.ID from Utente as u where u.username like usern and u.pass_word like pass) then
	signal sqlstate '45000' set message_text='inserire email e password valide';
    end if;
    

	select tipo from Utente where (username=usern and pass_word=pass);
    
end $$

