package it.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import it.corso.model.Attivita;
import it.corso.model.Turno;

import it.corso.service.AbbonamentoService;
import it.corso.service.AttivitaService;
import it.corso.service.TurnoService;
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
////////////////////////////////////////////////////////////////////////////	
	@GetMapping
	public String getPage(Model model,HttpSession session) {
		
		if(session.getAttribute("utente")==null)
			return "redirect:/";
		
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
	//TODO

/////////////////////////////////////////////////////////////////////////////
//	//TODO
//	@GetMapping("/getAttivita")
//	public String getAttivita(@RequestParam(name="id",required = false)int id,HttpSession session,Model model) {		
//		Attivita attivita = attivitaService.getAttivitaById(id);
//		model.addAttribute("attivita", attivita);
//		
//		//attivitaService.registraAttivita(attivita);
//		return "dettaglio";
//	}
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
