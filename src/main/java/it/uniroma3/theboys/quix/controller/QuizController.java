// package it.uniroma3.theboys.quix.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;

// import it.uniroma3.theboys.quix.model.Categoria;
// import it.uniroma3.theboys.quix.service.CategoriaService;

// //classe che gestisce le richieste http tramite metodi Java
// @Controller
// public class QuizController {

// 	@Autowired CategoriaService categoriaService;

// 	@GetMapping("/movie/{id}")	//risponde a una richiesta del tipo: /movie/3452
// 	public String getMovie(@PathVariable("id") Long id, Model model) {	//l'id preso dal path viene convertito in Long
// 		//model permette di scambiare dati tra la Vista e il Controller
// 		//con addAttribute() mettiamo a disposizione della Vista un oggetto che sarà il riferimento a "movie" per la Vista
// 		model.addAttribute("movie", this.categoriaService.getMovieById(id));	//l'id viene passato al metodo
// 		//la vista è movie.html
// 		return "movie.html";
// 	}

// 	@GetMapping("/movie")
//   	public String showMovies(Model model) {
//     	model.addAttribute("movies", this.movieService.getAllMovies());
//     	return "movies.html";
//   	}

// 	@GetMapping("/formNewMovie")
// 		public String formNewMovie(Model model) {
// 		model.addAttribute("movie", new Categoria());
// 		return "formNewMovie.html";
//   	}


// 	@PostMapping("/movie")
//   	public String newMovie(@ModelAttribute("movie") Categoria movie, Model model) {
// 		this.movieService.saveNewMovie(movie);
// 		//model.addAttribute("movie", movie);
// 		return "redirect:movie/"+movie.getId();
// 	}

// 	@GetMapping("/formSearchMovies")
//   	public String formSearchMovies() {
//     	return "formSearchMovies.html";
//   	}

//   	@PostMapping("/searchMovies")
// 	public String searchMovies(Model model, @RequestParam Integer year) {
// 		model.addAttribute("movies", this.movieService.findByYear(year));
// 		return "foundMovies.html";
// 	}


// }