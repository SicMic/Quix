package it.uniroma3.theboys.quix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.uniroma3.theboys.quix.model.Quiz;

//classe per le operazioni della persistenza (CRUD: CREATE, READ, UPDATE, DELETE)
public interface QuizRepository extends CrudRepository<Quiz, Long>{

    public List<Quiz> findQuizByCategoriaId (Long categoriaId);

    @Query(value = """
    SELECT q.*
    FROM quiz q
    JOIN raccolta r ON q.raccolta_id = r.id
    JOIN autore a ON r.autore_id = a.id
    WHERE a.id = :autoreId
    """, nativeQuery = true)
    public Iterable<Quiz> findQuizByAutoreIdNative(@Param("autoreId") Long autoreId);

    @Query(value = """
    SELECT q.*
    FROM quiz q
    JOIN raccolta r ON q.raccolta_id = r.id
    JOIN autore a ON r.autore_id = a.id
    JOIN categoria c ON q.categoria_id = c.id
    WHERE a.id = :autoreId and c.nome = :nomeCategoria
    """, nativeQuery = true)
    public Iterable<Quiz> findQuizByAutoreOfCategoriaIdNative(@Param("autoreId") Long autoreId, @Param("nomeCategoria") String nomeCategoria);


}
