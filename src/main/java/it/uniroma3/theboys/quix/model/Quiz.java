package it.uniroma3.theboys.quix.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity	
public class Quiz { //con @Entity il framework sa che a Movie bisogna associare una tabella nel database
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	//ogni volta che viene inserita un'entità 'Movie' nella tabella deve esserci la chiave 'id'
	private Long id;	//chiave primaria	
	
	@Column(nullable = false)
	private String quesito;

	@Column(nullable = false)
	private List <String> opzioni;

	@Column(nullable = false)
	private java.time.LocalDate dataCreazione;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}


	public String getQuesito() {
		return quesito;
	}

	public void setQuesito(String quesito) {
		this.quesito = quesito;
	}

	public List<String> getOpzioni() {
		return opzioni;
	}

	public void setOpzioni(List<String> opzioni) {
		this.opzioni = opzioni;
	}

	public java.time.LocalDate getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(java.time.LocalDate dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	//Non so se ha senso creare i metodi hashCode() e equals()

}