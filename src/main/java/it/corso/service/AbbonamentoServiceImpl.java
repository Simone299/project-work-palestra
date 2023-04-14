package it.corso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.AbbonamentoDao;
import it.corso.model.Abbonamento;
@Service
public class AbbonamentoServiceImpl implements AbbonamentoService {
	
	@Autowired
	private AbbonamentoDao abbonamentoDao;
	
	@Override
	public void registraAbbonamento(Abbonamento abbonamento) {
		
		abbonamentoDao.save(abbonamento);

	}

	@Override
	public Abbonamento getAbbonamentoById(int id) {
		
		
		return abbonamentoDao.findById(id).get();
	}

	@Override
	public List<Abbonamento> getAbbonamenti() {
		
		return   (List<Abbonamento>) abbonamentoDao.findAll();
	}

	@Override
	public void cancellaAbbonamento(Abbonamento abbonamento) {
		
		abbonamentoDao.delete(abbonamento);

	}

}
