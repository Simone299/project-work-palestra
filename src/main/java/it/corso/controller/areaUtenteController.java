package it.corso.controller;

import java.lang.ProcessBuilder.Redirect;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.hibernate.grammars.hql.HqlParser.IsEmptyPredicateContext;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.corso.model.Abbonamento;
import it.corso.model.Attivita;
import it.corso.model.Utente;
import it.corso.service.AbbonamentoService;
import it.corso.service.AttivitaService;
import it.corso.service.TurnoService;
import it.corso.service.UtenteService;
import jakarta.persistence.Id;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/areautente")
public class areaUtenteController {
@Autowired
private UtenteService utenteService;
@Autowired
private AbbonamentoService abbonamentoService;
@Autowired
private AttivitaService attivitaService;
@Autowired
private TurnoService turnoService;
/////////////////////////////////////////////////////////////

@GetMapping
//@ResponseBody
public String getPage(HttpSession session,Model model) {
	
	
	if(session.getAttribute("utente")==null)
		return "redirect:/logged";
	
	Utente utente=(Utente)session.getAttribute("utente");
	model.addAttribute("utente", utente);
	
	
	
	
	
	
    List<Abbonamento> abbonamenti = utente.getAbbonamenti();
    List<Abbonamento> abbonamentiAttivi= abbonamenti.stream().filter(a -> a.getData_fine().isAfter(LocalDateTime.now())).collect(Collectors.toList());
    
    model.addAttribute("abbonamentiattivi", abbonamentiAttivi);
    
    double prezzoTotale=0.0;
    
    for(Abbonamento scanner:abbonamenti) {
    	if(scanner.getData_fine().isAfter(LocalDateTime.now())) {   		
    	 Double prezzo= scanner.getImporto_totale();
    	prezzoTotale +=prezzo;}
    
    }
	model.addAttribute("prezzototale", prezzoTotale);
	
    List<Abbonamento> abbonamentiScaduti= abbonamentoService.abbonamentiScaduti(abbonamenti);
    model.addAttribute("abbonamentiscaduti", abbonamentiScaduti);
	 
	return "areautente";
}

@GetMapping("/rinnova")

public String rinnovaAbbonamento(@RequestParam(name="id") Integer id,HttpSession session) {
	

	
	
	 Abbonamento abbonamento = abbonamentoService.getAbbonamentoById(id);
	    LocalDateTime dataScadenza = abbonamento.getData_fine();
	    LocalDateTime dataRinnovo = dataScadenza.plusDays(30);
	    abbonamento.setData_fine(dataRinnovo);
	    abbonamentoService.registraAbbonamento(abbonamento);
	
	    Utente utente=(Utente)session.getAttribute("utente");
	    for (Abbonamento a : utente.getAbbonamenti()) {
	    	if(a.getId()==abbonamento.getId()) {
	    		a.setData_fine(dataRinnovo);
	    		break;
	    	}
	    }
	    session.setAttribute("utente", utente);
	    
	return "redirect:/areautente";
	
	
}
	
	
}
