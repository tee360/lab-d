package co.grandcircus.movies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.grandcircus.movies.dao.MovieDao;
import co.grandcircus.movies.model.Movie;

@Controller
public class RestController {
	
	@Autowired
	private MovieDao movieDao;

	// MediaType.APPLICATION_JSON_VALUE sets a Content-Type response header of "application/json"
	// @ResponseBody annotation, specifies that the return value is the body of the response rather than a view name
	@RequestMapping(value = "/rest/movies", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String listMovies(@RequestParam(value="category", required=false) String category) {
		List<Movie> movies;
		if (category != null && movieDao.isValidCategory(category)) {
			movies = movieDao.getMoviesByCategory(category);
		} else {
			movies = movieDao.getAllMovies();
		}
		StringBuilder response = new StringBuilder();
		appendMovies(response, movies);
		return response.toString();
	}
	
	@RequestMapping(value = "/rest/movies/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getMovie(@PathVariable("id") Integer id) {
		StringBuilder response = new StringBuilder();
		appendMovie(response, movieDao.getMovie(id));
		return response.toString();
	}
	
	/**
	 * Append a list of movies to a stringBuilder JSON
	 */
	private void appendMovies(StringBuilder response, List<Movie> movies) {
		response.append("[\n");
		for (Movie movie : movies) {
			appendMovie(response, movie);
			response.append(",\n");
		}
		response.deleteCharAt(response.length() - 2);
		response.append("]");
	}
	
	/**
	 * Append one movie to a stringBuilder JSON
	 */
	private void appendMovie(StringBuilder response, Movie movie) {
		response.append("  { \"id\": ")
        .append(movie.getId())
        .append(", \"title\": \"")
        .append(movie.getTitle())
        .append("\", \"category\": \"")
        .append(movie.getCategory())
        .append("\" }");
	}
	
}