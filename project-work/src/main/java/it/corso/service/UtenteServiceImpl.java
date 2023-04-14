package it.corso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.UtenteDao;
import it.corso.model.Utente;
import jakarta.servlet.http.HttpSession;


@Service
public class UtenteServiceImpl implements UtenteService {

	@Autowired
	private UtenteDao utenteDao;
	
	@Override
	public boolean verificaLogin(String username,String password,HttpSession session) {
		
		Utente utente= utenteDao.findByUsernameAndPassword(username, password);
		
		if(utente != null) {
			session.setAttribute("utente", utente);
			return true;
			}
		
		
		
		
		return false;
	}
	
	
	
	@Override
	public boolean verificaUtente(String username) {
		
		Utente utente= utenteDao.findByUsername(username);
		
		    if(utente==null) 
		    	return true;
		   
   return false;
	}
	
	
	@Override
	public void registraUtente(Utente utente,HttpSession session) {
		 
		session.setAttribute("utente", session);
		
		utenteDao.save(utente);
	}

	@Override
	public Utente getUtenteByid(int id) {
		
		return utenteDao.findById(id).get();
	}

	@Override
	public List<Utente> getUtenti() {
		
		return  (List<Utente>)  utenteDao.findAll();
	}

	@Override
	public void cancellaUtente(Utente utente) {
		utenteDao.delete(utente);

	}

}
