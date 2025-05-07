package it.uniroma3.theboys.quix.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.theboys.quix.model.Quiz;

//classe per le operazioni della persistenza (CRUD: CREATE, READ, UPDATE, DELETE)
public interface QuizRepository extends CrudRepository<Quiz, Long>{

    public List<Quiz> findQuizByCategoriaId (Long categoriaId);

}