/*
 * Source Material (c) 2016 GCD
 * All rights reserved
 */
package co.grandcircus.movies.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Repository;

import co.grandcircus.movies.exception.NotFoundException;
import co.grandcircus.movies.model.Movie;

/**
 * Responsibility: To provide access to all the movies.
 */
@Repository
public class MovieDaoImpl implements MovieDao {

	private List<Movie> movies = new ArrayList<Movie>();

	// Constructor
	public MovieDaoImpl() {
		movies.add(new Movie("Alien", "scifi"));
		movies.add(new Movie("Aliens", "scifi"));
		movies.add(new Movie("Prometheus", "scifi"));
		movies.add(new Movie("Airplane", "comedy"));
		movies.add(new Movie("Planes, Trains, and Automobiles", "comedy"));
		movies.add(new Movie("Nightmare on Elm Street", "horror"));
		movies.add(new Movie("Friday the 13th", "horror"));
		movies.add(new Movie("Child's Play", "horror"));
		movies.add(new Movie("Avengers", "action"));
		movies.add(new Movie("Captain America", "action"));
		assignIds();
	}

	/**
	 * Get all the movies from the array list... every single one.
	 */
	@Override
	public List<Movie> getAllMovies() {
		return movies;
	}

	@Override
	public List<Movie> getMoviesByCategory(String cat) {
		ArrayList<Movie> movieListByCat = new ArrayList<Movie>();

		for (Movie m : movies) {
			if (m.getCategory().equals(cat)) {
				movieListByCat.add(m);
			}
		}
		return movieListByCat;
	}

	@Override
	public Movie getMovie(int id) throws NotFoundException {
		try {
			int index = getIndexFromId(id);
			return movies.get(index);
		} catch (IndexOutOfBoundsException ex) {
			throw new NotFoundException("No movie " + id);
		}
	}

	@Override
	public int addMovie(Movie movie) {
		movies.add(movie);
		assignIds();
		return movie.getId();
	}

	@Override
	public void updateMovie(int id, Movie movie) throws NotFoundException {
		try {
			int index = getIndexFromId(id);
			movies.set(index, movie);
			assignIds();
		} catch (IndexOutOfBoundsException ex) {
			throw new NotFoundException("No movie " + id);
		}
	}
	
	@Override
	public void deleteMovie(int id) throws NotFoundException {
		try {
			int index = getIndexFromId(id);
			movies.remove(index);
			assignIds();
		} catch (IndexOutOfBoundsException ex) {
			throw new NotFoundException("No movie " + id);
		}
	}

	@Override
	public Set<String> getAllCategories() {
		Set<String> categories = new TreeSet<>();
		for (Movie movie : movies) {
			categories.add(movie.getCategory());
		}
		return categories;
	}

	@Override
	public boolean isValidCategory(String category) {
		return getAllCategories().contains(category);
	}
	
	private int getIndexFromId(int id) {
		return id - 1;
	}
	
	private void assignIds() {
		int id = 1;
		for (Movie movie : movies) {
			movie.setId(id++);
		}
	}
	
	
}
