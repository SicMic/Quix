package it.uniroma3.theboys.quix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.uniroma3.theboys.quix.model.Quiz;

//classe per le operazioni della persistenza (CRUD: CREATE, READ, UPDATE, DELETE)
public interface QuizRepository extends CrudRepository<Quiz, Long>{

    public Iterable<Quiz> findByCategoriaId (Long categoriaId);

    @Query(value = """
    SELECT q.*
    FROM quiz q
    JOIN raccolta r ON q.raccolta_id = r.id
    JOIN autore a ON r.autore_id = a.id
    WHERE a.id = :autoreId
    """, nativeQuery = true)
    public Iterable<Quiz> findByAutoreIdNative(@Param("autoreId") Long autoreId);

    @Query(value = """
    SELECT q.*
    FROM quiz q
    JOIN raccolta r ON q.raccolta_id = r.id
    JOIN autore a ON r.autore_id = a.id
    JOIN categoria c ON q.categoria_id = c.id
    WHERE a.id = :autoreId and c.nome = :nomeCategoria
    """, nativeQuery = true)
    public Iterable<Quiz> findByAutoreIdAndCategoriaNomeNative(@Param("autoreId") Long autoreId, @Param("nomeCategoria") String nomeCategoria);

    @Query("SELECT COUNT(q) FROM Quiz q JOIN q.raccolta r WHERE r.autore.id = :autoreId")
    Long countQuizByAutoreId(@Param("autoreId") Long autoreId);

    @Query(value = """
    SELECT c.nome, COUNT(q)
    FROM quiz q
    JOIN categoria c ON c.id = q.categoria_id 
    JOIN raccolta r ON r.id = q.raccolta_id
    JOIN autore a ON a.id = r.autore_id
    WHERE a.id = :autoreId
    GROUP BY c.nome
    ORDER BY COUNT(q) DESC
    """, nativeQuery = true)
    List<Object[]> countQuizPerCategoriaOrderByDesc(@Param("autoreId") Long autoreId);

}
