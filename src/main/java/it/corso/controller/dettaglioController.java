package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.model.Attivita;
import it.corso.service.AttivitaService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/dettaglio")
public class dettaglioController {
@Autowired
private AttivitaService attivitaService;

@GetMapping
public String getAttivita(@RequestParam(name="id",required = false)int id,HttpSession session,Model model) {	
	
	Attivita attivita = attivitaService.getAttivitaById(id);
	model.addAttribute("attivita", attivita);
	
	if(session.getAttribute("utente")!=null) {
		
		boolean ancora = true;
 		model.addAttribute("ancora", ancora);
		return "dettaglio";
	
	}
	
	
	return "redirect:/logged";
}
////////////////////////////////////////////////////////////////////
@GetMapping("/////ass/")
public String acquistaAttivita(@RequestParam("id")int id,HttpSession session) {
	

	
return "redirect:/logged";
}

}
