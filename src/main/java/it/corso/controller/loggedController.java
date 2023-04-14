package it.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.corso.model.Attivita;
import it.corso.model.Turno;
import it.corso.service.AttivitaService;
import it.corso.service.TurnoService;


@Controller
@RequestMapping("logged")
public class loggedController {
	@Autowired
	private AttivitaService attivitaService;
	@Autowired
	private TurnoService turnoService;
	
	@GetMapping
	public String getPage(Model model) {
		
		List<Attivita> listaAttivita = attivitaService.getAttivita();
		Attivita attivita = new Attivita();
		model.addAttribute("listaAttivita", listaAttivita);
		model.addAttribute("attivita", attivita);
		
		List<Turno> turni = turnoService.getTurni();
		Turno turno = new Turno();
		model.addAttribute("turni", turni);
		model.addAttribute("turno", turno);
		
		
		return "/logged";
	}

}
