package it.corso.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "attivita")
public class Attivita {
	
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;
 
 @Column(name="titolo")
 private String titolo;
 
 @Column(name="descrizione")
 private String descrizione;
 
 @Column(name="prezzo_totale")
 private double prezzo_totale;
 
 @Column(name="istruttore")
 private String istruttore;
 
 @OneToMany
 (
         mappedBy = "attivita",
         cascade = CascadeType.ALL,
         fetch = FetchType.EAGER,
         orphanRemoval = true
 )
 private List<Abbonamento> abbonamenti =  new ArrayList<>();
 
 @OneToMany
 (
         mappedBy = "attivita",
         cascade = CascadeType.ALL,
         fetch = FetchType.EAGER,
         orphanRemoval = true
 )
 private List<Turno> turni =  new ArrayList<>();

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getTitolo() {
	return titolo;
}

public void setTitolo(String titolo) {
	this.titolo = titolo;
}

public String getDescrizione() {
	return descrizione;
}

public void setDescrizione(String descrizione) {
	this.descrizione = descrizione;
}

public double getPrezzo_totale() {
	return prezzo_totale;
}

public void setPrezzo_totale(double prezzo_totale) {
	this.prezzo_totale = prezzo_totale;
}

public String getIstruttore() {
	return istruttore;
}

public void setIstruttore(String istruttore) {
	this.istruttore = istruttore;
}

public List<Abbonamento> getAbbonamenti() {
	return abbonamenti;
}

public void setAbbonamenti(List<Abbonamento> abbonamenti) {
	this.abbonamenti = abbonamenti;
}

public List<Turno> getTurni() {
	return turni;
}

public void setTurni(List<Turno> turni) {
	this.turni = turni;
}
 
 
 
}
