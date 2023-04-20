package it.corso.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

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
 private Double prezzo_totale;
 
 @Column(name="istruttore")
 private String istruttore;
 
 @Column(name="immagine")
 private String immagine;
 
 @Column(name="informazioni")
 private String informazioni;
 
 
 @Transient
 private MultipartFile immaginereale;
 
 public MultipartFile getImmaginereale() {
	return immaginereale;
}

public void setImmaginereale(MultipartFile immaginereale) {
	this.immaginereale = immaginereale;
}

public String getImmagine() {
	return immagine;
}

public void setImmagine(String immagine) {
	this.immagine = immagine;
}

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
         cascade = CascadeType.REFRESH,
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

public Double getPrezzo_totale() {
	return prezzo_totale;
}

public void setPrezzo_totale(Double prezzo_totale) {
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

public String getInformazioni() {
	return informazioni;
}

public void setInformazioni(String informazioni) {
	this.informazioni = informazioni;
}
 
 
 
}
