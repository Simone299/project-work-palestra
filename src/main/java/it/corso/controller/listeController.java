package it.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	

	boolean mostraDiv = false;
	boolean mostraForm = false;
	boolean mostraDiv2 = false;
	
	boolean mostraDiv3 = false;
	
	@GetMapping("/1")
	public String getpage1(Model model) {
		model.addAttribute("mostraDiv", mostraDiv);
		mostraDiv = true;
		
		List<Utente> listaUtente = utenteService.getUtenti();
		Utente utente = new Utente();
		model.addAttribute("listaUtente", listaUtente);
		model.addAttribute("utente", utente);
		
		
		return "liste";
	}
	
	
	@GetMapping("/2")
	public String getpage2(Model model) {
		
		model.addAttribute("mostraDiv2", mostraDiv2);
		mostraDiv2 = true;
		
		List<Abbonamento> listaAbbonamento = abbonamentoService.getAbbonamenti();
		Abbonamento abbonamento = new Abbonamento();
		model.addAttribute("listaAbbonamento", listaAbbonamento);
		model.addAttribute("abbonamento", abbonamento);
		
		return "liste";
	}
	
	@GetMapping("/3")
	public String getpage3(Model model) {
		
		model.addAttribute("mostraDiv3", mostraDiv3);
		mostraDiv3 = true;
		
		List<Attivita> listaAttivita = attivitaService.getAttivita();
		Attivita attivita = new Attivita();
		model.addAttribute("listaAttivita", listaAttivita);
		model.addAttribute("attivita", attivita);
		
		return "liste";
	}
	
	
	@GetMapping("/cancella")
	public String cancellaUtente(@RequestParam("id") int id)
	{
		Utente utente = utenteService.getUtenteByid(id);
		utenteService.cancellaUtente(utente);
		
		return "redirect:/lista/1";
	}
	
	
	@PostMapping("aggiungi")
	public String registraUtente(@ModelAttribute("utente") Utente utente) {
	    utenteService.registraUtente(utente);
	    return "redirect:/lista/1";
	}
	
	
	
	
}


