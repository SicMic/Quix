package it.uniroma3.theboys.quix.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity	
public class Quiz { //con @Entity il framework sa che a Movie bisogna associare una tabella nel database
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	//ogni volta che viene inserita un'entità 'Movie' nella tabella deve esserci la chiave 'id'
	private Long id;	//chiave primaria	
	
	@Column(nullable = false)
	private String quesito;

	@Column(nullable = false)
	private String opzioneUno;

	@Column(nullable = false)
	private String opzioneDue;

	@Column(nullable = false)
	private String opzioneTre;

	@Column(nullable = false)
	private String opzioneQuattro;

	@Column(nullable = false)
	private java.time.LocalDate dataCreazione;

	@ManyToOne
	private Categoria categoria;

	@ManyToOne
	private Autore autore;
	
	public Quiz(){
		this.quesito = "Quesito";
		this.opzioneUno = "opzione uno";
		this.opzioneDue = "opzione due";
		this.opzioneTre = "opzione tre";
		this.opzioneQuattro = "opzione quattro";
	}

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

	public java.time.LocalDate getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(java.time.LocalDate dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public String getOpzioneUno() {
		return opzioneUno;
	}

	public void setOpzioneUno(String opzioneUno) {
		this.opzioneUno = opzioneUno;
	}

	public String getOpzioneDue() {
		return opzioneDue;
	}

	public void setOpzioneDue(String opzioneDue) {
		this.opzioneDue = opzioneDue;
	}

	public String getOpzioneTre() {
		return opzioneTre;
	}

	public void setOpzioneTre(String opzioneTre) {
		this.opzioneTre = opzioneTre;
	}

	public String getOpzioneQuattro() {
		return opzioneQuattro;
	}

	public void setOpzioneQuattro(String opzioneQuattro) {
		this.opzioneQuattro = opzioneQuattro;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	//Non so se ha senso creare i metodi hashCode() e equals()

}