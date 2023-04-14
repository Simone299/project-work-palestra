package it.corso.service;

import java.util.List;

import it.corso.model.Turno;

public interface TurnoService {
	
	void registraTurnio(Turno turno);
	Turno getTurnoById(int id);
	List<Turno> getTurni();
	void cancellaTurno(Turno turno);
	
}
