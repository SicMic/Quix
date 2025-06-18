package it.uniroma3.theboys.quix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.theboys.quix.model.Categoria;
import it.uniroma3.theboys.quix.repository.CategoriaRepository;

//classe per definire le operazioni CRUD tramite metodi java: descrive i servizi offerti
@Service
public class CategoriaService {
	@Autowired private CategoriaRepository categoriaRepository;	//istanza costruita e inizializzata dal framework

    public Categoria getCategoriaById(Long id) {
        return this.categoriaRepository.findById(id).get();
    }

	public Categoria getCategoriaByNome(String nome) {
        return this.categoriaRepository.findByNome(nome).get();
    }

	public Iterable<Categoria> getAllCategorie(){
		return this.categoriaRepository.findAll();
	}
	
	public Categoria saveNewCategoria(Categoria c){
		return this.categoriaRepository.save(c);
	}

}