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
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "utenti")
public class Utente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "nome_utente")
	//@Pattern(regexp = "[a-zA-Z\\s']{1,255}", message = "caratteri non ammessi")
	private String nome_utente;
	
	@Column(name = "cognome_utente")
	//@Pattern(regexp = "[a-zA-Z\\s']{1,255}", message = "caratteri non ammessi")
	private String cognome_utente;
	
	@Column(name = "codice_fiscale")
	//@Pattern(regexp = "[a-zA-Z0-9\\s']{1,255}", message = "caratteri non ammessi")
	private String codice_fiscale;
	
	@Column(name = "email")
	//@Pattern(regexp = "[a-z0-9]+@[a-z.-]+\\.[a-z]{2,30}", message = "caratteri non ammessi")
	private String email;
	
	@Column(name = "username")
	//@Pattern(regexp = "[a-zA-Z.]{1,20}",message = "Username non valido")
	private String username;
	
	@Column(name = "password")
	//@Pattern(regexp = "(?=.[A-Z])(?=.[a-z])(?=.[0-9]).{5,30}",message = "password troppo debole")
	private String password;
	
	@OneToMany
    (
            mappedBy = "utente",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
	private List<Abbonamento> abbonamenti = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome_utente() {
		return nome_utente;
	}

	public void setNome_utente(String nome_utente) {
		this.nome_utente = nome_utente;
	}

	public String getCognome_utente() {
		return cognome_utente;
	}

	public void setCognome_utente(String cognome_utente) {
		this.cognome_utente = cognome_utente;
	}

	public String getCodice_fiscale() {
		return codice_fiscale;
	}

	public void setCodice_fiscale(String codice_fiscale) {
		this.codice_fiscale = codice_fiscale;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Abbonamento> getAbbonamenti() {
		return abbonamenti;
	}

	public void setAbbonamenti(List<Abbonamento> abbonamenti) {
		this.abbonamenti = abbonamenti;
	}
}
