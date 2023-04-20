package it.corso.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.model.Abbonamento;
import it.corso.model.Attivita;
import it.corso.model.Turno;
import it.corso.model.Utente;
import it.corso.service.AbbonamentoService;
import it.corso.service.AttivitaService;
import it.corso.service.TurnoService;
import it.corso.service.UtenteService;
import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/logged")
public class loggedController {
	@Autowired
	private AttivitaService attivitaService;
	@Autowired
	private TurnoService turnoService;
    @Autowired
    private AbbonamentoService abbonamentoService;
    @Autowired
    private UtenteService utenteService;
////////////////////////////////////////////////////////////////////////////	
	@GetMapping
	public String getPage(Model model,HttpSession session,@RequestParam(name = "confermato",required = false) String confermato) {
		
		if(session.getAttribute("utente")==null)
			return "redirect:/";
		
		model.addAttribute("confermato", confermato != null);
		
		List<Attivita> listaAttivita = attivitaService.getAttivita();
		Attivita attivita = new Attivita();
		model.addAttribute("listaAttivita", listaAttivita);
		model.addAttribute("attivita", attivita);
		
		List<Turno> turni = turnoService.getTurni();
		Turno turno = new Turno();
		model.addAttribute("turni", turni);
		model.addAttribute("turno", turno);
		return "logged";
	}
/////////////////////////////////////////////////////////////////////////////






/////////////////////////////////////////////////////////////////////////////
//	@GetMapping("/acquista")
//	public String acquistaAttivita(@ModelAttribute("attivita")Attivita attivita) {
//		
//		attivitaService.registraAttivita(attivita);
//	
//		
//	return "redirect:/logged";
//	}
	
	
	
	
}
