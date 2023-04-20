package it.corso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("loginAdmin")
public class adminController {
	
	@GetMapping
	public String getpage7(HttpSession session) {
		
		if(session.getAttribute("amministratore")== null)
			return "redirect:/";
		
		
		return "areaadmin";
	}
	
	
}
