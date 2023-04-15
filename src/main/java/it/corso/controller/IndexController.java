package it.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import it.corso.model.Attivita;
import it.corso.model.Turno;
import it.corso.model.Utente;
import it.corso.service.AmministratoreService;
import it.corso.service.AttivitaService;
import it.corso.service.TurnoService;
import it.corso.service.UtenteService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class IndexController {
	@Autowired
	private UtenteService utenteService;
	@Autowired
	private AmministratoreService amministratoreService;
	@Autowired
	private AttivitaService attivitaService;
    @Autowired
    private TurnoService turnoService;
	@GetMapping
	public String getPage(Model model,@RequestParam(name="err",required = false) String errore1,
			@RequestParam(name="err2",required = false) String errore2,
			@RequestParam(name="err3",required = false) String errore3,
			@RequestParam(name="ceck",required = false) String ceck){
       
		model.addAttribute("errore3", errore3 != null);
		model.addAttribute("errore2", errore2 != null);
		model.addAttribute("ceck", ceck != null);
		model.addAttribute("errore", errore1 != null); 
        		
		Utente utente= new Utente();
		model.addAttribute("utente", utente);
		
		
		List<Turno>	turni= turnoService.getTurni();
		model.addAttribute("turni", turni);
			
		 List<Attivita> attivita = attivitaService.getAttivita();//findAll()----------ho richiamato al posto di findall il metodo già implementato che li prende
	     model.addAttribute("attivita", attivita); 
			
		
		
		
		
		return "index";
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@PostMapping
	public String registraUtente(@Valid @ModelAttribute ("utente") Utente utente,BindingResult result,
			
			HttpSession session,Model model) {
				
   	   if(utenteService.verificaUtente(utente.getUsername())== false) 
   		   
		return "redirect:/?err";//da modificare ritornando una pagina "utente gia presente"
   	   
			utenteService.registraUtente(utente,session);
				
		return "redirect:/?ceck";
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	@PostMapping("/loginUtente")
	public String loginUtente(@RequestParam (name="username",required=false)String username,
			@RequestParam(name="password",required = false) String password,HttpSession session) {
		
		if(utenteService.verificaLogin(username, password, session))//<--- tolto il ==true
			return "redirect:/logged";
		
		
		return "redirect:/?err2";
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	 @PostMapping("/loginAdmin")
	 public String loginAmministratore(@RequestParam (name="username",required=false)String username,
			@RequestParam(name="password",required = false) String password,HttpSession session) {
		 
		 if(amministratoreService.verificaLogin(username, password, session)== true)
				return "areaadmin";
			
			
			return "redirect:/?err3";
	 }
	 
	 
}