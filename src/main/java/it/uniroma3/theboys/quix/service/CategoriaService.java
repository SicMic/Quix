package it.uniroma3.theboys.quix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.theboys.quix.model.Categoria;
import it.uniroma3.theboys.quix.model.Etichetta;
import it.uniroma3.theboys.quix.repository.CategoriaRepository;

//classe per definire le operazioni CRUD tramite metodi java: descrive i servizi offerti
@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository categoriaRepository;	//istanza costruita e inizializzata dal framework

    public Categoria getQuizById(Long id) {
        return categoriaRepository.findById(id).get();
    }

	public Categoria getQuizByName(String nome) {
        return categoriaRepository.findCategoriaByNome(nome);
    }

	public Iterable<Categoria> getAllCategories(){
		return categoriaRepository.findAll();
	}
	
	public Categoria save(Categoria c){
		return this.categoriaRepository.save(c);
	}

}