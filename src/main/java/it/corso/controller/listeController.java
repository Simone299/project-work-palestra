package it.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import it.corso.model.Abbonamento;
import it.corso.model.Attivita;

import it.corso.model.Utente;
import it.corso.service.AbbonamentoService;
import it.corso.service.AttivitaService;
import it.corso.service.UtenteService;

@Controller
@RequestMapping("/lista")
public class listeController {
	
	@Autowired
	UtenteService utenteService;
	@Autowired
	AbbonamentoService abbonamentoService;
	@Autowired
	AttivitaService attivitaService;
	
	
	
	@GetMapping("/1")
	public String getpage1(Model model) {
		
		
		
		List<Utente> lista = utenteService.getUtenti();
		Utente oggetto = new Utente();
		model.addAttribute("lista", lista);
		model.addAttribute("oggetto", oggetto);
		
		return "liste";
	}
	
	
	@GetMapping("/2")
	public String getpage2(Model model) {
		
		
		
		List<Abbonamento> lista = abbonamentoService.getAbbonamenti();
		Abbonamento oggetto = new Abbonamento();
		model.addAttribute("lista", lista);
		model.addAttribute("oggetto", oggetto);
		
		return "liste";
	}
	
	@GetMapping("/3")
	public String getpage3(Model model) {
		
		
		
		List<Attivita> lista = attivitaService.getAttivita();
		Attivita oggetto = new Attivita();
		model.addAttribute("lista", lista);
		model.addAttribute("oggetto", oggetto);
		
		return "liste";
	}
}


