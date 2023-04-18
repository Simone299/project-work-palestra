package it.corso.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.corso.dao.AttivitaDao;
import it.corso.model.Abbonamento;
import it.corso.model.Attivita;
import it.corso.model.Turno;
import it.corso.model.Utente;
import it.corso.service.AbbonamentoService;
import it.corso.service.AttivitaService;
import it.corso.service.TurnoService;
import it.corso.service.UtenteService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/lista")
public class listeController {
	
	@Autowired
	AttivitaDao attivitaDao;
	@Autowired
	UtenteService utenteService;
	@Autowired
	AbbonamentoService abbonamentoService;
	@Autowired
	AttivitaService attivitaService;
	@Autowired
	TurnoService turnoService;
	
	private Attivita attivita;
	

	boolean mostraDiv = false;
	boolean mostraDiv2 = false;
	boolean mostraDiv3 = false;
	
	
	
	
	@GetMapping("/1")
	public String getpage1(Model model) {
		 
		
		mostraDiv = true;
		model.addAttribute("mostraDiv", mostraDiv);
		
		List<Utente> listaUtente = utenteService.getUtenti();
		Utente utente = new Utente();
		model.addAttribute("listaUtente", listaUtente);
		model.addAttribute("utente", utente);
		
		
		return "liste";
	}
	
	
	@GetMapping("/2")
	public String getpage2(Model model) {
		
		mostraDiv2 = true;
		model.addAttribute("mostraDiv2", mostraDiv2);
		
		
		List<Abbonamento> listaAbbonamento = abbonamentoService.getAbbonamenti();
		Abbonamento abbonamento = new Abbonamento();
		model.addAttribute("listaAbbonamento", listaAbbonamento);
		model.addAttribute("abbonamento", abbonamento);
		
		return "liste";
	}
	
	@GetMapping("/3")
	public String getpage3(Model model) {
		
		mostraDiv3 = true;
		model.addAttribute("mostraDiv3", mostraDiv3);
		
		
		List<Attivita> listaAttivita = attivitaService.getAttivita();
		Attivita attivita = new Attivita();
		model.addAttribute("listaAttivita", listaAttivita);
		model.addAttribute("attivita", attivita);
		
		List<Turno> listaTurni = turnoService.getTurni();
		Turno turno = new Turno();
		model.addAttribute("listaTurni", listaTurni);
		model.addAttribute("turno", turno);
		
		return "liste";
	}
	
	@GetMapping("/cancella3")
	public String cancellaAttivita(@RequestParam("id") int id)
	{
		
		Attivita attivita = attivitaService.getAttivitaById(id);
		attivitaService.cancellaAttivita(attivita);
		
		return "redirect:/lista/3";
	}
	
	
	  @PostMapping("aggiungi3") public String
	  registraAttivita(@ModelAttribute("attivita") Attivita attivita) {
	  attivitaService.registraAttivita(attivita); return "redirect:/lista/3"; }
	 
	

	/*
	 * @GetMapping("/cercaattivita") public String
	 * modificaAttivita(@RequestParam(name="id",required = false) int id,Model
	 * model) {
	 * 
	 * Attivita attivita =attivitaService.getAttivitaById(id);
	 * model.addAttribute("attivita", attivita);
	 * 
	 * return "prova"; }
	 */
	
	@PostMapping("/modificaattivita")
	public String modificaAttivita(@RequestParam(name = "id") int id,
			@RequestParam(name="titolo")String titolo,
			@RequestParam(name="descrizione")String descrizione,
			@RequestParam(name="prezzo_totale") double prezzo_totale,
			@RequestParam(name="istruttore") String istruttore,HttpSession session) {
		
		Attivita attivita = attivitaService.getAttivitaById(id);
		attivita.setTitolo(titolo);
		attivita.setDescrizione(descrizione);
		attivita.setPrezzo_totale(prezzo_totale);
		attivita.setIstruttore(istruttore);
		
		attivitaService.registraAttivita(attivita);
		
		
		return "redirect:/lista/3";
	}

	
	/*
	 * @PostMapping("/creaattivita") public String creaAttivita (@ModelAttribute
	 * ("attivita") Attivita attivita,HttpSession session) {
	 * 
	 * 
	 * attivitaService.registraAttivita(attivita);
	 * 
	 * 
	 * return "redirect:/lista/3"; }
	 */
	
	
	
	
	
	@PostMapping("aggiungi6")
	public String registraTurno(@ModelAttribute("turno") Turno turno) {
	    turnoService.registraTurnio(turno);
	    return "redirect:/lista/3";
	}
	
	
	
	
}
	
	



