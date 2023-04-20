package it.corso.controller;

import java.time.LocalDateTime;
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
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/dettaglio")
public class dettaglioController {
@Autowired
private AttivitaService attivitaService;

@Autowired
private AbbonamentoService abbonamentoService;

@GetMapping
public String getAttivita(@RequestParam(name="id",required = false)int id,HttpSession session,Model model) {	
	
	Attivita attivita = attivitaService.getAttivitaById(id);
	model.addAttribute("attivita", attivita);
	

	
	double prezzogiorno=attivita.getPrezzo_totale();
	double prezzosconto=prezzogiorno* 8 * 0.85;
	model.addAttribute("prezzosconto", prezzosconto);
	
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

@GetMapping("confermaAcquisto")
public String confermaAcquisto(@RequestParam(name="id",required = false) int id,HttpSession session, Model model) {
	
	Attivita attivita=attivitaService.getAttivitaById(id);
	
	
	model.addAttribute("attivita", attivita);
	
	 
	
	
	
	
	
	
	
	return "pagamento";
}

@GetMapping("registraabbonamento")
public String registraAbbonamento(@RequestParam(name="id",required = false) int id,HttpSession session) {
	
	Attivita attivita=attivitaService.getAttivitaById(id);
	Utente utente =(Utente) session.getAttribute("utente");
	 
	
	
	Abbonamento abbonamento= new Abbonamento();
	abbonamento.setAttivita(attivita);
	abbonamento.setUtente(utente);
	abbonamento.setData_inizio(LocalDateTime.now());
	abbonamento.setData_fine(LocalDateTime.now().plusDays(30));
	abbonamento.setImporto_toatale(attivita.getPrezzo_totale() * 8 * 0.85);
	
	abbonamentoService.registraAbbonamento(abbonamento);
	
	List<Abbonamento> abbonamenti = utente.getAbbonamenti();
	abbonamenti.add(abbonamento);
	utente.setAbbonamenti(abbonamenti);
	
	
	return "redirect:/logged?confermato";
}

}
