package it.corso.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "abbonamenti")

public class Abbonamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "data_inizio")
	private LocalDate data_inizio;
	
	@Column(name = "data_fine")
	private LocalDate data_fine;
	
	@Column(name = "importo_totale")
	private double importo_totale;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_utente", referencedColumnName = "id")
	private Utente utente;
	
	@ManyToOne(cascade = CascadeType.REFRESH) //da verificare
    @JoinColumn(name = "id_attivita", referencedColumnName = "id")
	private Attivita attivita;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getData_inizio() {
		return data_inizio;
	}

	public void setData_inizio(LocalDate data_inizio) {
		this.data_inizio = data_inizio;
	}

	public LocalDate getData_fine() {
		return data_fine;
	}

	public void setData_fine(LocalDate data_fine) {
		this.data_fine = data_fine;
	}

	public double getImporto_toatale() {
		return importo_totale;
	}

	public void setImporto_toatale(double importo_toatale) {
		this.importo_totale = importo_toatale;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Attivita getAttivita() {
		return attivita;
	}

	public void setAttivita(Attivita attivita) {
		this.attivita = attivita;
	}
	
	
}
