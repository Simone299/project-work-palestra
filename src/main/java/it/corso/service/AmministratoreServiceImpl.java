package it.corso.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.AmministratoreDao;

import it.corso.model.Amministratore;

import jakarta.servlet.http.HttpSession;
@Service
public class AmministratoreServiceImpl implements AmministratoreService {
    @Autowired
    private AmministratoreDao amministratoreDao;
    
    
    
    
    
	@Override
	public boolean verificaLogin(String username, String password, HttpSession session) {
		
		Amministratore amministratore= amministratoreDao.findByUsernameAndPassword(username, password);
	    if(amministratore != null ) {
	    	session.setAttribute("amministratore", amministratore);
	    	return true;}
		
	    return false;
	}

	

}
