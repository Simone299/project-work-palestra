package it.corso.service;

import java.util.List;

import it.corso.model.Utente;
import jakarta.servlet.http.HttpSession;


public interface UtenteService {
	
	boolean verificaLogin(String username,String password,HttpSession session);
    boolean verificaUtente(String username);
	void registraUtente(Utente utente,HttpSession session);
	Utente getUtenteByid(int id);
	List<Utente> getUtenti();
	void cancellaUtente(Utente utente);
	
}
