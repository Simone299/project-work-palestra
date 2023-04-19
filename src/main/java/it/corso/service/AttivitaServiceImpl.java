package it.corso.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import it.corso.dao.AttivitaDao;
import it.corso.model.Attivita;

@Service
public class AttivitaServiceImpl implements AttivitaService {

	@Autowired
	private AttivitaDao attivitaDao;
	
	@Override
	public void registraAttivita(Attivita attivita) {
		
		if (attivita.getImmaginereale() != null && !attivita.getImmaginereale().isEmpty())
            try
            {
                attivita.setImmagine("data:image/jpg;base64," + Base64.getEncoder().encodeToString(attivita.getImmaginereale().getBytes()));
            } catch (IOException e)
            {
                e.printStackTrace();
            }
		
		attivitaDao.save(attivita);

	}

	@Override
	public Attivita getAttivitaById(int id) {
		
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

	@Override
	public List<Attivita> findAll() {
		
		return (List<Attivita>) attivitaDao.findAll();
		
	}

}
