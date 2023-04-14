package it.corso.service;

import java.util.List;

import it.corso.model.Attivita;

public interface AttivitaService {
	
	void registraAttivita(Attivita attivita);
	Attivita getAttivitabyId(int id);
	List<Attivita> getAttivita();
	void cancellaAttivita(Attivita attivita);
}
