package it.corso.service;




import jakarta.servlet.http.HttpSession;

public interface AmministratoreService {

	public boolean verificaLogin(String username,String password,HttpSession session);

	
}
