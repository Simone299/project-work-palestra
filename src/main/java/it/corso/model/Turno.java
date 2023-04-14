package it.corso.model;

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
@Table(name = "turni")
public class Turno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="giorno_settimana")
	private String giorno_settimana;
	
	@Column(name="fascia_oraria")
	private String fascia_oraria;
	
	@ManyToOne(cascade = CascadeType.REFRESH) //da verificare
    @JoinColumn(name = "id_attivita", referencedColumnName = "id")
	private Attivita attivita;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGiorno_settimana() {
		return giorno_settimana;
	}

	public void setGiorno_settimana(String giorno_settimana) {
		this.giorno_settimana = giorno_settimana;
	}

	public String getFascia_oraria() {
		return fascia_oraria;
	}

	public void setFascia_oraria(String fascia_oraria) {
		this.fascia_oraria = fascia_oraria;
	}

	public Attivita getAttivita() {
		return attivita;
	}

	public void setAttivita(Attivita attivita) {
		this.attivita = attivita;
	}
}
