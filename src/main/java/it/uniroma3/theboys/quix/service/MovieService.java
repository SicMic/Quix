package it.uniroma3.siw.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Movie;
import it.uniroma3.siw.repository.MovieRepository;

//classe per definire le operazioni CRUD tramite metodi java: descrive i servizi offerti
@Service
public class MovieService {
	@Autowired
	private MovieRepository movieRepository;	//istanza costruita e inizializzata dal framework
	
	public Iterable<Movie> getAllMovies(){
		return movieRepository.findAll();
	}

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).get();
    }

	public Movie saveNewMovie(Movie movie){
		return this.movieRepository.save(movie);
	}

	public Iterable<Movie> findByYear(Integer year){
		ArrayList<Movie> lst = new ArrayList<>();
		Iterable<Movie> lista= this.movieRepository.findAll();
		for (Movie m : lista)
			if(m.getYear().equals(year))
				lst.add(m);
		
		return lst;
	}
}