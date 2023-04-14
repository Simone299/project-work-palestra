package it.corso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.TurnoDao;
import it.corso.model.Turno;

@Service
public class TurnoServiceImpl implements TurnoService {

	@Autowired
	private TurnoDao turnoDao;
	
	@Override
	public void registraTurnio(Turno turno) {
		
		turnoDao.save(turno);

	}

	@Override
	public Turno getTurnoById(int id) {
		
		return turnoDao.findById(id).get();
	}

	@Override
	public List<Turno> getTurni() {
		
		return 	(List<Turno>)	turnoDao.findAll();
	}

	@Override
	public void cancellaTurno(Turno turno) {
		
		turnoDao.delete(turno);

	}

}
