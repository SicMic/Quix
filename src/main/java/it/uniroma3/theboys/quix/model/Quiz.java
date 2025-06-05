package it.uniroma3.theboys.quix.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OrderBy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class Quiz { // con @Entity il framework sa che a Movie bisogna associare una tabella nel
					// database

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // ogni volta che viene inserita un'entità 'Movie' nella tabella
													// deve esserci la chiave 'id'
	private Long id; // chiave primaria

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
	private java.time.LocalDateTime dataCreazione;

	@ManyToOne
	private Raccolta raccolta;

	@ManyToOne
	private Categoria categoria;

	// DA TOGLIERE SE NON SERVE
	public Quiz() {
		this.quesito = "Quesito";
		this.opzioneUno = "opzione uno";
		this.opzioneDue = "opzione due";
		this.opzioneTre = "opzione tre";
		this.opzioneQuattro = "opzione quattro";
		this.dataCreazione = java.time.LocalDateTime.now();
	}

	public Quiz(String quesito, String opzioneUno, String opzioneDue, String opzioneTre, String opzioneQuattro,
			Raccolta raccolta, Categoria categoria) {
		this.quesito = quesito;
		this.opzioneUno = opzioneUno;
		this.opzioneDue = opzioneDue;
		this.opzioneTre = opzioneTre;
		this.opzioneQuattro = opzioneQuattro;
		this.raccolta = raccolta;
		this.categoria = categoria;
		this.dataCreazione = java.time.LocalDateTime.now();
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

	public java.time.LocalDateTime getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(java.time.LocalDateTime dataCreazione) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((quesito == null) ? 0 : quesito.hashCode());
		result = prime * result + ((opzioneUno == null) ? 0 : opzioneUno.hashCode());
		result = prime * result + ((opzioneDue == null) ? 0 : opzioneDue.hashCode());
		result = prime * result + ((opzioneTre == null) ? 0 : opzioneTre.hashCode());
		result = prime * result + ((opzioneQuattro == null) ? 0 : opzioneQuattro.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quiz other = (Quiz) obj;
		if (quesito == null) {
			if (other.quesito != null)
				return false;
		} else if (!quesito.equals(other.quesito))
			return false;
		if (opzioneUno == null) {
			if (other.opzioneUno != null)
				return false;
		} else if (!opzioneUno.equals(other.opzioneUno))
			return false;
		if (opzioneDue == null) {
			if (other.opzioneDue != null)
				return false;
		} else if (!opzioneDue.equals(other.opzioneDue))
			return false;
		if (opzioneTre == null) {
			if (other.opzioneTre != null)
				return false;
		} else if (!opzioneTre.equals(other.opzioneTre))
			return false;
		if (opzioneQuattro == null) {
			if (other.opzioneQuattro != null)
				return false;
		} else if (!opzioneQuattro.equals(other.opzioneQuattro))
			return false;
		return true;
	}

	public Raccolta getRaccolta() {
		return raccolta;
	}

	public void setRaccolta(Raccolta raccolta) {
		this.raccolta = raccolta;
	}

	public void shuffle() {
		List<String> opzioni = new ArrayList<>();
		opzioni.add(opzioneUno);
		opzioni.add(opzioneDue);
		opzioni.add(opzioneTre);
		opzioni.add(opzioneQuattro);

		Collections.shuffle(opzioni);

		// Assegna le opzioni mescolate di nuovo ai campi
		opzioneUno = opzioni.get(0);
		opzioneDue = opzioni.get(1);
		opzioneTre = opzioni.get(2);
		opzioneQuattro = opzioni.get(3);
	}

}