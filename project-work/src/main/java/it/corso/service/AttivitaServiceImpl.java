package it.corso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.AttivitaDao;
import it.corso.model.Attivita;

@Service
public class AttivitaServiceImpl implements AttivitaService {

	@Autowired
	private AttivitaDao attivitaDao;
	
	@Override
	public void registraAttivita(Attivita attivita) {
		attivitaDao.save(attivita);

	}

	@Override
	public Attivita getAttivitabyId(int id) {
		
		return attivitaDao.findById(id).get();
	}

	@Override
	public List<Attivita> getAttivita() {
		
		return 	(List<Attivita>)	attivitaDao.findAll();
	}

	@Override
	public void cancellaAttivita(Attivita attivita) {
		
		attivitaDao.delete(attivita);

	}

}
