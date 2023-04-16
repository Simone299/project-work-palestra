package it.corso.service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
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
	@CacheEvict(value = "abbonamenti", allEntries = true)
	public Abbonamento getAbbonamentoById(int id) {
		
		
		return abbonamentoDao.findById(id).get();
	}

	@Override
	public List<Abbonamento> getAbbonamenti() {
		
		return   (List<Abbonamento>) abbonamentoDao.findAll();
	}

	@Override
	@CacheEvict(value = "abbonamenti", allEntries = true)
	public void cancellaAbbonamento(Abbonamento abbonamento) {
		
		abbonamentoDao.delete(abbonamento);

	}
	@Override
	public List<Abbonamento> abbonamentiScaduti(List<Abbonamento> abbonamenti){
		
		   List<Abbonamento> abbonamentiScaduti = new ArrayList<>();
		    LocalDateTime dataCorrente = LocalDateTime.now();
		 
		    for(Abbonamento abbonamento : abbonamenti) {
		        LocalDateTime dataScadenza = abbonamento.getData_fine();
		        if(dataCorrente.isAfter(dataScadenza)) {
		            abbonamentiScaduti.add(abbonamento);
		        }
		    }

	    return abbonamentiScaduti;
	}
	
	
	

}
