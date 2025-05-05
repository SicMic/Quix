package it.uniroma3.theboys.quix.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity	
public class Categoria { //con @Entity il framework sa che a Movie bisogna associare una tabella nel database
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	//ogni volta che viene inserita un'entità 'Movie' nella tabella deve esserci la chiave 'id'
	private Long id;	//chiave primaria	
	
	@Column(unique = true, nullable = false)
	private String nome;

	@Column(nullable = false)
	private String descrizione;

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

	 

}