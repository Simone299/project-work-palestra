package it.corso.service;

import java.util.List;

import it.corso.model.Abbonamento;


public interface AbbonamentoService {

	List<Abbonamento> abbonamentiScaduti(List<Abbonamento> abbonamenti);
	void registraAbbonamento(Abbonamento abbonamento);
	Abbonamento getAbbonamentoById (int id);
	List<Abbonamento> getAbbonamenti();
	void cancellaAbbonamento(Abbonamento abbonamento);
	
}
