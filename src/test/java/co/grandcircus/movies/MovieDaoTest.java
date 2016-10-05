/*
 * Source Material (c) 2016 GCD
 * All rights reserved
 */
package co.grandcircus.movies;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import co.grandcircus.movies.dao.MovieDao;
import co.grandcircus.movies.dao.MovieDaoImpl;
import co.grandcircus.movies.exception.NotFoundException;
import co.grandcircus.movies.model.Movie;


public class MovieDaoTest {
	
	MovieDao dao = new MovieDaoImpl();
	
	@Test
	public void allMoviesShouldReturn10Movies() {
		List<Movie> allMovies = dao.getAllMovies();
		Assert.assertEquals(10, allMovies.size());
	}
	
	@Test
	public void theFirstMovieIsAlien() {
		List<Movie> allMovies = dao.getAllMovies();
		Movie firstMovie = allMovies.get(0);
		Assert.assertEquals("Alien", firstMovie.getTitle());
		Assert.assertEquals("scifi", firstMovie.getCategory());
	}
	
	@Test
	public void threeMoviesInTheScifiCategory() {
		List<Movie> moviesInScifiCat = dao.getMoviesByCategory("scifi");
		Assert.assertEquals(3, moviesInScifiCat.size());
	}
	
	@Test
	public void theFirstMovieInTheComedyCatIsAirplane() {
		List<Movie> moviesInComedyCat = dao.getMoviesByCategory("comedy");
		Movie firstMovie = moviesInComedyCat.get(0);
		Assert.assertEquals("Airplane", firstMovie.getTitle());
		Assert.assertEquals("comedy", firstMovie.getCategory());
	}
	
	@Test
	public void addMovie() {
		Movie movie = new Movie("Expendables", "action");
		dao.addMovie(movie);
		
		movie = dao.getMovie(11);
		Assert.assertEquals("Expendables", movie.getTitle());
		Assert.assertEquals("action", movie.getCategory());
	}
	
	@Test
	public void updateMovie() {
		Movie movie = new Movie("Expendables", "action");
		dao.updateMovie(5, movie);
		
		movie = dao.getMovie(5);
		Assert.assertEquals("Expendables", movie.getTitle());
		Assert.assertEquals("action", movie.getCategory());
		int size = dao.getAllMovies().size();
		Assert.assertEquals(10, size);
	}
	
	@Test(expected = NotFoundException.class)
	public void updateMovieTooLow() {
		Movie movie = new Movie("Expendables", "action");
		dao.updateMovie(0, movie);
	}
	
	@Test(expected = NotFoundException.class)
	public void updateMovieTooHigh() {
		Movie movie = new Movie("Expendables", "action");
		dao.updateMovie(11, movie);
	}
	
	@Test
	public void deleteMovie() {
		dao.deleteMovie(5);
		
		Movie movie = dao.getMovie(5);
		Assert.assertEquals("Nightmare on Elm Street", movie.getTitle());
		Assert.assertEquals("horror", movie.getCategory());
		int size = dao.getAllMovies().size();
		Assert.assertEquals(9, size);
	}
	
	@Test(expected = NotFoundException.class)
	public void deleteMovieTooLow() {
		dao.deleteMovie(0);
	}
	
	@Test(expected = NotFoundException.class)
	public void deleteMovieTooHigh() {
		dao.deleteMovie(11);
	}

}
