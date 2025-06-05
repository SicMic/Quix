package it.uniroma3.theboys.quix.model;

import java.time.LocalDateTime;

// import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;

@Entity	
public class Raccolta { //con @Entity il framework sa che a Movie bisogna associare una tabella nel database
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	//ogni volta che viene inserita un'entità 'Movie' nella tabella deve esserci la chiave 'id'
	private Long id;	//chiave primaria	
	
	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String descrizione;

	private LocalDateTime dataCreazione;

	private String urlImage;

	@ManyToOne
	@JoinColumn(name="autore_id", nullable=false)
	private Autore autore;

	@OneToMany(mappedBy="raccolta", cascade = CascadeType.REMOVE)
	@OrderBy("dataCreazione DESC")
	private List<Quiz> elencoQuiz;

	@ManyToOne
	private Etichetta etichetta;

	public Raccolta(){				// controllare se serve inserire istruzioni
		this.dataCreazione = java.time.LocalDateTime.now();
	}

	public Raccolta(String nome, String urlImage, Etichetta etichetta, String descrizione, Autore autore){
		this();
		this.nome = nome;
		this.urlImage = urlImage;
		this.etichetta = etichetta;
		this.descrizione = descrizione;
		this.autore = autore;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		
		this.id = id;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public List<Quiz> getElencoQuiz() {
		return elencoQuiz;
	}

	public void setElencoQuiz(List<Quiz> elencoQuiz) {
		this.elencoQuiz = elencoQuiz;
	}

	public Autore getAutore() {
		return autore;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}

	public Etichetta getEtichetta() {
		return etichetta;
	}

	public void setEtichetta(Etichetta etichetta) {
		this.etichetta = etichetta;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public LocalDateTime getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(LocalDateTime dataCreazione) {
		this.dataCreazione = dataCreazione;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((descrizione == null) ? 0 : descrizione.hashCode());
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
		Raccolta other = (Raccolta) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
			return false;
		return true;
	}

}